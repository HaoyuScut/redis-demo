package com.itwhy;

import com.itwhy.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * RedisTemplate可以接收任意Object作为值写入Redis，
 * 只不过写入前会把Object序列化为字节形式，默认是采用JDK序列化，
 * 可读性差，占用内存大
 *
 * 为了节省内存空间，我们并不会使用)SON序列化器来处理value，
 * 而是统一使用String序列化器，要求只能存储String类型的key和value。
 * 当需要存储Java对象时，手动完成对象的序列化和反序列化。
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

    @Test
    void testSaveUser() {
        //写入数据
        redisTemplate.opsForValue().set("user:100", new User("虎哥", 21));
        //获取数据
        User o = (User) redisTemplate.opsForValue().get("user:100");
        System.out.println("o = " + o);
    }

}
