package com.scau.redis.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

/**
 * RedisConfig:redis配置类
 *
 * @author chen
 * @date 2019/03/09
 */
@Configuration
public class RedisConfig {

    /**
     * 使用自定义的CacheManager
     *
     * @param factory
     * @return
     */
    @Primary
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheWriter writer = RedisCacheWriter.nonLockingRedisCacheWriter(factory);
        RedisSerializer<Object> serializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(serializer);
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair)
                .entryTtl(Duration.ofSeconds(3600))
                .disableCachingNullValues();
        RedisCacheManager cacheManager = new RedisCacheManager(writer, configuration);
        return cacheManager;
    }
}
