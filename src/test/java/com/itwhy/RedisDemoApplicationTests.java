package com.itwhy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * RedisTemplate可以接收任意Object作为值写入Redis，
 * 只不过写入前会把Object序列化为字节形式，默认是采用JDK序列化，
 * 可读性差，占用内存大
 */

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testString() {
        //写入一条String数据
        redisTemplate.opsForValue().set("name", "虎哥");
        //获取String数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

}
