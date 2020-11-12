package hbrs.ooka.cache;

import java.util.List;

public interface Caching {

    void cacheResult(String key, List<? extends Object> value);

    List<Object> getEntry(String key);

}
