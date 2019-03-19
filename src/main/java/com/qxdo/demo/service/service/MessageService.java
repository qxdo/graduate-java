package com.qxdo.demo.service.service;

import com.qxdo.demo.entity.Message;

import java.util.List;


public interface MessageService {

    boolean save(Message message);

    Message selectbyid(Integer id);

    boolean delete(Integer id);



    List<Message> selectbyuserid(Integer userid);

    boolean deletebyuserid(Integer userid);
}
