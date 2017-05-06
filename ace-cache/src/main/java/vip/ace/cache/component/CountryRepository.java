package vip.ace.cache.component;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = "countries")
public class CountryRepository {

	@Cacheable
    public String findByCode(String code) {
		System.out.println("---> Loading country with code '" + code + "'");
		return code;
	}

}