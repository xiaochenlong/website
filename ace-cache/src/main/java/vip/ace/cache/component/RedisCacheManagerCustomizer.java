package vip.ace.cache.component;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.DefaultRedisCachePrefix;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xcl on 2017/3/30.
 */
@Component
public class RedisCacheManagerCustomizer implements CacheManagerCustomizer {

    @Override
    public void customize(CacheManager cacheManager) {
        if(cacheManager instanceof RedisCacheManager){
            RedisCacheManager cacheManager0 = (RedisCacheManager) cacheManager;
            cacheManager0.setDefaultExpiration(5000);
            cacheManager0.setCachePrefix(new DefaultRedisCachePrefix());
            Map<String, Long> expries = new HashMap<>();
            expries.put("countries",100l);
            cacheManager0.setExpires(expries);
        }
    }

}
