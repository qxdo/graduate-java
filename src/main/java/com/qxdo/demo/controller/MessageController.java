package com.qxdo.demo.controller;

import com.qxdo.demo.common.Result;
import com.qxdo.demo.entity.Message;
import com.qxdo.demo.service.service.MessageService;
import com.qxdo.demo.util.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/selectbyuserid")
    public Result selectMessageByUserId(Integer userid){

        List<Message> messages =   messageService.selectbyuserid(userid);
        if( null != messages && messages.size() > 0){
            return ResultTool.SUCCESS(messages);
        }
        return ResultTool.FAIL("查询数据为空");
    }

    @GetMapping("/deletebyid/{id}")
    public Result deleteMessageById(@PathVariable Integer id){
        if(messageService.delete(id)){
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();
    }
    @GetMapping("/deletebyuserid/{userid}")
    public Result deleteMessageByUserId(@PathVariable Integer userid){
        if(messageService.deletebyuserid(userid)){
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();

    }



}
