package com.jh.sl.util;

import lombok.Data;

@Data
public class KVItem<K, V> {

    private final K key;
    private final V value;

    public KVItem(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
