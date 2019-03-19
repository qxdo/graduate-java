package com.qxdo.demo.controller;

import com.qxdo.demo.common.Result;
import com.qxdo.demo.dao.ContactDao;
import com.qxdo.demo.entity.CType;
import com.qxdo.demo.entity.Customer;
import com.qxdo.demo.service.service.CustomerService;
import com.qxdo.demo.util.ResultTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @RequestMapping("/save")
    public Result saveCustomer(@RequestParam String name,
                               @RequestParam Integer typeid,
                               @RequestParam String companyname,
                               @RequestParam String url,
                               @RequestParam String desc,
                               @RequestParam Integer imcount){
        Customer customer = new Customer();
        customer.setCompanyname(companyname);
        customer.setDesc(desc);
        customer.setImcount(imcount);
        customer.setName(name);
        customer.setUrl(url);
        CType ctype = new CType();
        ctype.setId(typeid);
        customer.setType(ctype);
        if(customerService.save(customer)){
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();
    }

    @RequestMapping("/update")
    public Result updateCustomer(@RequestParam String name,
                               @RequestParam Integer id,
                               @RequestParam Integer typeid,
                               @RequestParam String companyname,
                               @RequestParam String url,
                               @RequestParam String desc,
                               @RequestParam Integer imcount){
        Customer customer = new Customer();
        customer.setCompanyname(companyname);
        customer.setDesc(desc);
        customer.setImcount(imcount);
        customer.setName(name);
        customer.setUrl(url);
        CType ctype = new CType();
        ctype.setId(typeid);
        customer.setType(ctype);
        customer.setId(id);
        if(customerService.update(customer)){
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();
    }
    @GetMapping("/selectbyinfo")
    public Result updateCustomer(@RequestParam String info){

        List<Customer> customers =  customerService.selectbyinfo(info);

        if( null != customers && customers.size() > 0 ){

            return ResultTool.SUCCESS(customers);
        }
        return ResultTool.FAIL("失败");

    }

    @RequestMapping("/delete/{id}")
    public Result deleteCustomer(@PathVariable Integer id){
        customerService.delete(id);



        return ResultTool.FAIL("失败");

    }
}
