package com.qxdo.demo;

import com.qxdo.demo.dao.UserDao;
import com.qxdo.demo.entity.User;
import com.qxdo.demo.util.DateTimeTool;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class TestUserDao extends  DemoApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    public void userDaoMutiCondication(){

        LocalDateTime from = DateTimeTool.string2LocalDateTime("2018-01-01-00:00:00");
        LocalDateTime to =   DateTimeTool.string2LocalDateTime("2019-03-14-00:00:00");
        List<User> users =  userDao.selectbymuticondication(null,null,null,null,from,to);
        for(User user : users){
            System.out.println(user.getUsername());

        }

    }
}
