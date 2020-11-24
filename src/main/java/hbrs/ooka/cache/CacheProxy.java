package hbrs.ooka.cache;

import java.util.List;

public class CacheProxy implements Caching {
    private Caching cache;

    public CacheProxy() {
        this.cache = new Cache();
    }

    @Override
    public void cacheResult(String key, List<?> value) {
        this.cache.cacheResult(key, value);
    }

    @Override
    public List<Object> getEntry(String key) {
        return this.cache.getEntry(key);
    }
}
