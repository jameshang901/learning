package com.jh.sl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class AppTest {

    @Test
    public void testPing() {
        App app = new App();
        Assert.assertTrue(app.ping());
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
    }

    @Test
    public void testMap() {
        List<Map<String, String>> lists = new ArrayList<>();
        lists.add(Map.of("k11", "v11", "k12", "v12"));
        lists.add(Map.of("k11", "v21", "k12", "v22"));
        lists.add(Map.of("k31", "v31", "k32", "v32"));
        lists.stream().flatMap(v -> v.entrySet().stream()).forEach(es -> {
            log.info("k: {}, v: {}", es.getKey(), es);
        });
    }

}
