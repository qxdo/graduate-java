package com.qxdo.demo.service.impl;

import com.qxdo.demo.dao.ContactDao;
import com.qxdo.demo.entity.Contact;
import com.qxdo.demo.service.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public boolean save(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public boolean update(Contact contact) {
        return contactDao.update(contact);
    }

    @Override
    public boolean delete(Integer id) {
        return contactDao.delete(id);
    }

    @Override
    public List<Contact> listAll() {
        return contactDao.listAll();
    }

    @Override
    public List<Contact> selectByContact(String info) {
        return contactDao.selectByContactInfo(info);
    }
}
