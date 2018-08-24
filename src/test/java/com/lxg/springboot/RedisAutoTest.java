package com.lxg.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: RedisAutoTest
 * @Description: Redis测试
 * @Author GX
 * @Date 2018/06/12 上午 11:14
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisAutoTest {
    /*@Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void save() {
        redisTemplate.opsForValue().set("zzp","big z");
        System.out.println(redisTemplate.opsForValue().get("zzp"));
    }*/
}
