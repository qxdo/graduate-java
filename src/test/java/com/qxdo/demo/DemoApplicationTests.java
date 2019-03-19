package com.qxdo.demo;

import com.qxdo.demo.dao.UserDao;
import com.qxdo.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
        List<User> users =  userDao.listAll();
        for(User user: users){
            LocalDate now = LocalDate.now();
            LocalDate date = user.getBirthday();
            if((date.getMonth().getValue() - now.getMonth().getValue() == 0) && (date.getDayOfMonth() - now.getDayOfMonth() == 0) ){
                System.out.println("today is your birthday");

                System.out.println("=========今日生日名单===========");
                System.out.println(user.getUsername());
                System.out.println("==============================");



            }








        }


    }

}
