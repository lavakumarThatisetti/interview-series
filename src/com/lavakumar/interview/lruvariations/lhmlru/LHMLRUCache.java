package com.lavakumar.interview.lruvariations.lhmlru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LHMLRUCache<K,V> {
    LinkedHashMap<K,V> cache;
    int MAX_SIZE;
    public LHMLRUCache(int capacity){
        MAX_SIZE = capacity;
        cache = new LinkedHashMap<K,V>(2,0.75f, true){
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > MAX_SIZE;
            }
        };
    }

    public void put(K k, V v){
        cache.put(k,v);
    }

    public V get(K k){
        return cache.getOrDefault(k,null);
    }

    public boolean remove(K k){
        V remove = cache.remove(k);
        return remove != null;
    }
}
