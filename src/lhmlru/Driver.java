package lhmlru;

public class Driver {
    public static void main(String[] args) {
        LHMLRUCache<Integer, String> cache = new LHMLRUCache<>(3);
        cache.put(1,"c++");
        cache.put(2,"Java");
        cache.put(3,"Python");
        System.out.println(cache.get(1)); // c++;
        cache.put(4,"GoLang");
        System.out.println(cache.get(2)); // null;
        cache.put(3,"Spring");
        System.out.println(cache.get(1)); //c++;
        cache.put(5,"fastAPi");
        System.out.println(cache.get(4)); //null
    }
}
