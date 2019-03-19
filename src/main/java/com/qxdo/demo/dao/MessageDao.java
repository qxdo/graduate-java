package com.qxdo.demo.dao;

import com.qxdo.demo.entity.Message;
import com.qxdo.demo.provider.MessageProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageDao {
    @InsertProvider(type = MessageProvider.class,method = "saveMessage")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer save(@Param("message") Message message);


    @Select("select id,message,userid,modifiedtime from message where id=#{id}")
    @Results({
            @Result(property="user",column="userid",one = @One(select = "com.qxdo.demo.dao.UserDao.selectbyid"))
    })
    Message selectbyid(Integer id);

    @Delete("delete from message where id=#{id}")
    Integer delete(Integer id);


    @Delete("delete from message where userid=#{userid}")
    Integer deletebyuserid(Integer userid);

    @Select("select id,message,userid,modifiedtime from message where userid=#{userid} order by modifiedtime desc")

    @Results({
            @Result(property="user",column="userid",one = @One(select = "com.qxdo.demo.dao.UserDao.selectbyid"))
    })
    List<Message> selectbyuserid(Integer userid);
}
