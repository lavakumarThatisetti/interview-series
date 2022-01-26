package lru;

import java.util.HashMap;

public class LRUCache<K,V> {
    Node<K,V> head;
    Node<K,V> tail;
    HashMap<K, Node<K,V>> map;
    final int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }

    public V get(K key) {
        if(map.get(key)==null){
            return null;
        }
        Node<K,V> t = map.get(key);

        removeNode(t);
        offerNode(t);

        return t.value;
    }

    public void put(K key, V value) {
        if(map.containsKey(key)){
            Node<K,V> t = map.get(key);
            t.value = value;
            // Remove Node as it Most Recently Used
            removeNode(t);
            // Insert Node
            offerNode(t);
        }else{
            if(map.size()>=cap){
                //delete head as
                map.remove(head.key);
                removeNode(head);
            }
            //add to tail
            Node<K,V> node = new Node<>(key, value);
            offerNode(node);
            map.put(key, node);
        }
    }

    private void removeNode(Node<K,V> n){
        if(n.prev!=null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.prev = n.prev;
        }else{
            tail = n.prev;
        }
    }

    private void offerNode(Node<K,V> n){
        if(tail!=null){
            tail.next = n;
        }
        n.prev = tail;
        n.next = null;
        tail = n;

        if(head == null){
            head = tail;
        }
    }
}
