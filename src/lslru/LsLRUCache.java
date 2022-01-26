package lslru;

import java.util.HashMap;
import java.util.LinkedList;


public class LsLRUCache<K,V> {
    LinkedList<K> keys;
    HashMap<K,V> cache;
    int MAX_SIZE;
    public LsLRUCache(int capacity){
        MAX_SIZE = capacity;
        keys = new LinkedList<>();
        cache = new HashMap<>();
    }

    public void put(K k, V v){
        if(cache.containsKey(k)){
            keys.removeFirstOccurrence(k);
        } else if (cache.size() == MAX_SIZE){
            K removedValue = keys.removeLast();
            cache.remove(removedValue);
        }
        cache.put(k,v);
        keys.addFirst(k);
    }

    public V get(K k){
        if(cache.containsKey(k)){
            keys.removeFirstOccurrence(k);
            keys.addFirst(k);
        }
        return cache.getOrDefault(k,null);
    }

    public boolean remove(K k){
        V remove = cache.remove(k);
        keys.removeFirstOccurrence(k);
        return remove != null;
    }
}
