package com.qxdo.demo.service.service;

import com.qxdo.demo.entity.Customer;

import java.util.List;

public interface CustomerService {

    boolean save(Customer customer);

    boolean update(Customer customer);


    List<Customer> selectbyinfo(String info);

    boolean delete(Integer id);
}
