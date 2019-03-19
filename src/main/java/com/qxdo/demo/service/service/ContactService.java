package com.qxdo.demo.service.service;

import com.qxdo.demo.entity.Contact;

import java.util.List;

public interface ContactService {

    boolean save(Contact contact);

    boolean update(Contact contact);

    boolean delete(Integer id);

    List<Contact> listAll();

    List<Contact> selectByContact(String info);

}
