package com.jh.sl.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.streams.KafkaStreams;
import org.junit.Test;

import java.time.Duration;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

@Slf4j
public class KafkaUtilsTest {

    @Test
    public void testNormal() {
        String server = "127.0.0.1:9092";
        String topic = "topic001";
        String groupId = "group001";
        try (Producer<String, String> producer = KafkaUtils.createProducer(server); Consumer<String, String> consumer = KafkaUtils.createConsumer(server, groupId)) {
            String key = UUID.randomUUID().toString();
            String value = UUID.randomUUID().toString();
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);
            Future<RecordMetadata> future = producer.send(producerRecord);
            RecordMetadata recordMetadata = future.get(1, TimeUnit.SECONDS);
            log.info("Topic: {}", recordMetadata.topic());
            consumer.subscribe(List.of(topic));
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            consumerRecords.records(topic).forEach(consumerRecord -> {
                log.info("key: {}, value: {}", consumerRecord.key(), consumerRecord.value());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStream() {
        String server = "127.0.0.1:9092";
        String topic = "topic001";
        String appId = "myApp001";
        try (KafkaStreams streams = KafkaUtils.createStreams(server, appId, topic, new MyProcessor()); Producer<String, String> producer = KafkaUtils.createProducer(server);) {
            streams.start();

            for (int i = 0; i < 10; i++) {
                String key = UUID.randomUUID().toString();
                key = "key001";
                String value = UUID.randomUUID().toString();
                ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);
                Future<RecordMetadata> future = producer.send(producerRecord);
                RecordMetadata recordMetadata = future.get(1, TimeUnit.SECONDS);
                Thread.sleep(500);
            }

            log.info("Datasource is empty now...");
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Slf4j
    private static class MyProcessor implements Predicate<KVItem<String, String>> {

        @Override
        public boolean test(KVItem kvItem) {
            log.info("K: {}, V: {}", kvItem.getKey(), kvItem.getValue());
            return false;
        }
    }

}
