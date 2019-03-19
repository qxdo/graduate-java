package com.qxdo.demo.controller;

import com.qxdo.demo.common.Result;
import com.qxdo.demo.entity.Contact;
import com.qxdo.demo.service.service.ContactService;

import com.qxdo.demo.util.ResultTool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController  {
    @Autowired
    private ContactService contactService;
    @PostMapping("/save")
    public Result saveContact(@RequestParam String name,
                              @RequestParam String customername,
                              @RequestParam String phone,
                              @RequestParam String email,
                              @RequestParam String nickname){
        Contact contact = new Contact();
        contact.setName(name);
        contact.setCustomername(customername);
        contact.setEmail(email);
        contact.setNickname(nickname);
        contact.setPhone(phone);
        if(contactService.save(contact)){
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();
    }

    @PostMapping("/update")
    public Result updateContact(@RequestParam String name,
                              @RequestParam Integer id,
                              @RequestParam String customername,
                              @RequestParam String phone,
                              @RequestParam String email,
                              @RequestParam String nickname){
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);
        contact.setCustomername(customername);
        contact.setEmail(email);
        contact.setNickname(nickname);
        contact.setPhone(phone);

        if(contactService.update(contact)){
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();
    }
    @GetMapping("/delete")
    public Result deleteContact(@RequestParam Integer id){

        if (contactService.delete(id) ) {
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();
    }

    @GetMapping("/list")
    public Result listContact(){
        List<Contact> contacts = contactService.listAll();

        if( null != contacts && contacts.size() > 0){
            return ResultTool.SUCCESS(contacts);
        }
        return ResultTool.FAIL();
    }


    @PostMapping("/selectbyname")
    public Result updateContact(@RequestParam String name){
        Contact contact = new Contact();

        List<Contact> contacts =  contactService.selectByContact(name);

        if( null != contacts &&  contacts.size() > 0 ){

            return ResultTool.SUCCESS(contacts);
        }
        return ResultTool.FAIL();
    }


}
