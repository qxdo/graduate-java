package com.qxdo.demo.controller;

import com.qxdo.demo.common.Result;
import com.qxdo.demo.entity.User;
import com.qxdo.demo.service.service.UserService;

import com.qxdo.demo.util.DateTimeTool;
import com.qxdo.demo.util.ResultTool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 多条件查询
     * @param username
     * @param operator1
     * @param sex
     * @param operator2
     * @param from
     * @param to
     * @return
     */
    @PostMapping("/selectmuticondication")
    public Result selectMutiCondication(@RequestParam(required = false) String username,
                                  @RequestParam(required = false) Integer operator1,
                                  @RequestParam(required = false) Integer sex,
                                  @RequestParam(required = false) Integer operator2,
                                  @RequestParam(required = false) Long from,
                                  @RequestParam(required = false) Long to){
        LocalDateTime from1 = null;

        LocalDateTime to1 = null;

        String str1= "",str2 = "";

        /*logger.info("123");
        logger.info("{},{},{},{},{},{}",username,operator1,sex,operator2,from,to);
        logger.info("456");*/
        if( !Objects.equals(null,from) && !Objects.equals(null,to)){

            from1=LocalDateTime.ofEpochSecond(from,0, ZoneOffset.ofHours(8));
            to1 =LocalDateTime.ofEpochSecond(to,0, ZoneOffset.ofHours(8));
        }
        //logger.info("out of from...to...");
        if(null != operator1){
            str1  =  operator1 == 1 ? "or":"and";
        }
        if( null != operator2 ){
            str1  =  operator2 == 1 ? "or":"and";
        }


        List<User> users = userService.selectbymuticondication(username,str1, sex, str2, from1,to1);

        //logger.info("out of select....");

        if(null != users && users.size() > 0){
            return ResultTool.SUCCESS(users);
        }
        return ResultTool.FAIL();
    }

    /**
     * 新增用户记录
     * @param username
     * @param address
     * @param contact
     * @param level
     * @param backup
     * @return
     */
    @PostMapping("/save")
    public Result saveUser(@RequestParam String username,
                           @RequestParam String address,
                           @RequestParam String contact,
                           @RequestParam String birthday,
                           @RequestParam Integer sex,
                           @RequestParam Integer level,
                           @RequestParam String backup){
        User user = new User();
        user.setAddress(address);
        user.setBackup(backup);
        user.setContact(contact);
        user.setDeleted(0);
        user.setSex(sex);
        user.setLevele(level);
        user.setBirthday(DateTimeTool.string2LocalDate(birthday));
        user.setUsername(username);
        user.setModifiedtime(LocalDateTime.now());



        if(userService.save(user)){
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();
    }

    /**
     * 查询所有用户信息记录
     * @return
     */

    @GetMapping("/list")
    public Result listUser(){
        List<User> users = userService.listAll();
        if( null != users && users.size() > 0){
            return ResultTool.SUCCESS(users);
        }
        return ResultTool.FAIL();

    }

    /**
     * 用户信息修改
     * @param username
     * @param id
     * @param address
     * @param contact
     * @param birthday
     * @param level
     * @param backup
     * @return
     */

    @PostMapping("/update")
    public Result updateUser(@RequestParam String username,
                             @RequestParam Integer id,
                             @RequestParam String address,
                             @RequestParam String contact,
                             @RequestParam String birthday,
                             @RequestParam Integer level,
                             @RequestParam Integer sex,
                             @RequestParam String backup){
        User user = new User();

        user.setAddress(address);
        user.setBackup(backup);
        user.setContact(contact);
        user.setDeleted(0);
        user.setLevele(level);
        user.setSex(sex);
        user.setBirthday(DateTimeTool.string2LocalDate(birthday));
        user.setUsername(username);
        user.setModifiedtime(LocalDateTime.now());

        user.setId(id);
        if(userService.update(user)){
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();
    }

    /**
     * 用户信息删除
     *
     * @param id
     * @return
     */

    @GetMapping("/delete/{id}")
    public Result deleteUser(@PathVariable Integer id){

        User user = new User();
        user.setDeleted(1);
        user.setModifiedtime(LocalDateTime.now());
        user.setId(id);

        if(userService.update(user)){
            return ResultTool.SUCCESS();
        }
        return ResultTool.FAIL();
    }

    /**
     * 根据用户名查询用户记录
     * @param username
     * @return
     */
    @GetMapping("/selectbyusername")
    public Result selectByUserName(@RequestParam String username){

        User user = userService.selectbyusername(username);

        if(null != user ) {
            return ResultTool.SUCCESS(user);
        }
        return ResultTool.FAIL("数据为空");

    }

}
