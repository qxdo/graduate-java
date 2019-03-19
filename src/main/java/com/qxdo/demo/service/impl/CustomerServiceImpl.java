package com.qxdo.demo.service.impl;

import com.qxdo.demo.dao.CustomerDao;
import com.qxdo.demo.entity.Customer;
import com.qxdo.demo.service.service.CustomerService;
import com.qxdo.demo.util.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean save(Customer customer) {
        return customerDao.save(customer) ==1;
    }

    @Override
    public boolean update(Customer customer) {
        return customerDao.update(customer) == 1;
    }

    @Override
    public List<Customer> selectbyinfo(String info) {
        return customerDao.selectbyinfo(info);
    }

    @Override
    public boolean delete(Integer id) {

        Customer customer = new Customer();
        customer.setId(id);
        customer.setDeleted(1);

        return customerDao.update(customer) == 1;

    }

}
