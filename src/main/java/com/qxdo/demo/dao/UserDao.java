package com.qxdo.demo.dao;

import com.qxdo.demo.entity.Charts;
import com.qxdo.demo.entity.User;
import com.qxdo.demo.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserDao {

    @InsertProvider(type = UserProvider.class,method = "saveUser")
    @Options(useGeneratedKeys=true,keyProperty="id")
    Integer save(@Param("user")User user);

    @UpdateProvider(type=UserProvider.class,method="updateUser")
    Integer update(@Param("user")User user);


    @Update("update user set deleted=1 where id=#{id} and username=#{user.username} and deleted=0")
    Integer delete(@Param("user")User user);


    @Select("select id,username,sex,birthday,address,contact,levele,modifiedtime,backup,deleted from user where username=#{username} and deleted=0")
    User selectbyusername(String username);

    @Select("select id,username,sex,birthday,address,contact,levele,modifiedtime,backup,deleted,sex from user where deleted=0")

    List<User> listAll();

    @SelectProvider(type = UserProvider.class,method="selectbymuticondication")
    List<User> selectbymuticondication(@Param("username") String username,
                                       @Param("operator1")String operator1,
                                       @Param("sex") Integer sex,
                                       @Param("operator2")String operator2,
                                       @Param("from") LocalDateTime from,
                                       @Param("to") LocalDateTime to);


    //id,username,birthday,address,contact,levele,modifiedtime,backup,deleted


    @Select("select id,username,sex,birthday,address,contact,levele,modifiedtime,backup,deleted from user where id=#{id} and deleted=0")
    User selectbyid(Integer id);

    @Select("select modifiedtime as title,count(id) as data from user group by modifiedtime")
    List<Charts> selectpeerdayuserincreased();


}
