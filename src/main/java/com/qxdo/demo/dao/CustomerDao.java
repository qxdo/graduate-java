package com.qxdo.demo.dao;

import com.qxdo.demo.entity.Customer;
import com.qxdo.demo.provider.CustomerProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CustomerDao {
    @InsertProvider(type = CustomerProvider.class,method = "saveCustomer")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer save(@Param("customer")Customer customer);


    @UpdateProvider(type=CustomerProvider.class,method = "updateCustomer")
    Integer update(@Param("customer")Customer customer);

    @Select("select name,typeid,companyname,url,desc,imcount from customer where name=#{info} or companyname=#{info}")
    List<Customer> selectbyinfo(String info);




}
