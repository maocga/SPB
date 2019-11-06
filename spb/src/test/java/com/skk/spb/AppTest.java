package com.skk.spb;

import com.skk.spb.dao.BookDao;
import com.skk.spb.entity.Book;
import com.skk.spb.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class AppTest {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test01(){
        List<Book> all = bookDao.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
    }

    @Test
    public void testRedisTemplate(){
        redisTemplate.opsForValue().set("hello","world");

        String hello = (String) redisTemplate.opsForValue().get("hello");
        System.out.println(hello);
        Car car = new Car(1,"法拉利","红色",1500000d);
        redisTemplate.opsForValue().set("car",car);

        Car car1 = (Car)redisTemplate.opsForValue().get("car");
        System.out.println(car1);
    }


}
