package com.qxdo.demo.service.impl;

import com.qxdo.demo.dao.MessageDao;
import com.qxdo.demo.dao.UserDao;
import com.qxdo.demo.entity.Message;

import com.qxdo.demo.service.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(Message message) {
        return messageDao.save(message) == 1;
    }

    @Override
    public Message selectbyid(Integer id) {
        Message message =messageDao.selectbyid(id);

        if(message.getUser() != null){
            Integer userid = message.getUser().getId();
            userDao.selectbyid(userid);
        }
        return message;
    }

    @Override
    public boolean delete(Integer id) {
        return messageDao.delete(id) == 1;
    }


    @Override
    public List<Message> selectbyuserid(Integer userid) {
        return messageDao.selectbyuserid(userid);
    }

    @Override
    public boolean deletebyuserid(Integer userid) {
        return messageDao.deletebyuserid(userid) == 1;
    }
}
