package hbrs.ooka.system;

import hbrs.ooka.cache.CacheProxy;
import hbrs.ooka.cache.Caching;

import java.util.HashMap;
import java.util.List;

public class PortCaching {

    private Caching cache;

    public Caching getCache() {
        if(cache == null){
            cache = new CacheProxy();
        }
        return cache;
    }

    public void setCache(Caching cache) {
        this.cache = cache;
    }

}
