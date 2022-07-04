package com.itheima.test;

import com.itheima.reggie.ReggieApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@SpringBootTest(classes = ReggieApplication.class)
@RunWith(SpringRunner.class)
public class UploadFileTest {


    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("city123", "beijing");
        String city123 = (String) redisTemplate.opsForValue().get("city123");
        System.out.println(city123);
    }

    @Test
    public void text2(){
        HashOperations HashOperations = redisTemplate.opsForHash();
        HashOperations.put("002","name","xiaoming");
        HashOperations.put("002","age","20");
        HashOperations.put("002","address","bj");
        String name = (String) HashOperations.get("002", "name");
        System.out.println(name);

        Set keys = HashOperations.keys("002");
        for (Object key : keys) {
            System.out.println(key);
        }

        List values = HashOperations.values("002");
        for (Object value : values) {
            System.out.println(value);

        }


    }

    @Test
    public void test3 (){
        ListOperations ListOperations = redisTemplate.opsForList();
        ListOperations.leftPushAll("mylist","a");
        ListOperations.leftPushAll("mylist","b","c");
        List <String >mylist = ListOperations.range("mylist", 0, -1);
        for (String s : mylist) {
            System.out.println(s);
        }
        Long size = ListOperations.size("mylist");


    }

    @Test
    public void test4 (){


    }



}
