package vip.ace.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import vip.ace.cache.component.CountryRepository;

import java.util.Date;

/**
 * Created by xcl on 2017/3/23.
 */
@SpringBootApplication
@EnableCaching
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @Autowired
    private StringRedisTemplate template;
    @Autowired
    RedisTemplate redisTemplate;

    // RedisCacheConfiguration
    @Autowired
    CacheManager cacheManager;

    @Autowired
    CountryRepository countryRepository;

    @Override
    public void run(String... args) throws Exception {

        ValueOperations<String, String> v = template.opsForValue();
        v.set("springboot-1",new Date().toString(), 10000);

        cacheManager.getCache("redis1").put("kk","bbb");

        Boolean b = redisTemplate.hasKey("springboot-1");

        System.out.println(b);
        System.out.println(">>>>>>"+template.keys("*"));
        System.out.println(">>>>>>"+redisTemplate.keys("*"));
        System.out.println(cacheManager.getCacheNames());

        if(cacheManager instanceof RedisCacheManager){
            RedisCacheManager cacheManager0 = (RedisCacheManager) cacheManager;
            System.out.println(cacheManager);
        }

        while(true){
            System.out.println(countryRepository.findByCode("ccck"));
            Thread.sleep(1000);
        }




    }
}
