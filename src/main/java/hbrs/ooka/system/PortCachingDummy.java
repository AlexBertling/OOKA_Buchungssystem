package hbrs.ooka.system;

import hbrs.ooka.cache.Caching;

import java.util.List;

public class PortCachingDummy implements Caching {
    @Override
    public void cacheResult(String key, List<? extends Object> value) {

    }

    @Override
    public List<Object> getEntry(String key) {
        return null;
    }
}
