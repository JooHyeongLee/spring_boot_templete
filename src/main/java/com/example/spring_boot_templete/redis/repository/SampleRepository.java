package com.example.spring_boot_templete.redis.repository;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SampleRepository {
    private Logger log = LoggerFactory.getLogger(SampleRepository.class);

    private final RedisTemplate<String, Object> redisTemplate;

    public long setAdd(String key, String value) {
        return redisTemplate.opsForSet().add(key, value);
    }
}
