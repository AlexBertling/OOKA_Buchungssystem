package hbrs.ooka.system;

import hbrs.ooka.cache.Caching;

import java.util.HashMap;
import java.util.List;

public class PortCaching implements Caching {

    private final HashMap<String, List<Object>> hashmap = new HashMap<>();

    @Override
    public void cacheResult(String key, List<? extends Object> value) {
        hashmap.put(key, (List<Object>) value);
    }

    @Override
    public List<Object> getEntry(String key) {
        System.out.println(hashmap.get(key));
        return hashmap.get(key);
    }
}
