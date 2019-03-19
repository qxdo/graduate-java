package com.qxdo.demo;

import com.qxdo.demo.dao.MessageDao;
import com.qxdo.demo.entity.Message;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageDaoTest extends  DemoApplicationTests {
    @Autowired
    private MessageDao messageDao;
    @Test
    public void test(){
        Message mess = messageDao.selectbyid(1);
        System.out.println(mess);
    }
}
