package com.qxdo.demo.dao;

import com.qxdo.demo.entity.Contact;
import com.qxdo.demo.provider.ContactProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContactDao {

    @Insert("insert into contact(name,customername,phone,email,nickname) value(#{contact.name},#{contact.customername},#{contact.phone},#{contact.email},#{contact.nickname})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    boolean save(@Param("contact") Contact contact);

    @UpdateProvider(type = ContactProvider.class,method = "updateContact")
    boolean update(@Param("contact") Contact contact);

    @Delete("delete from contact where id=#{id}")
    boolean delete(Integer id);

    @Select("select id,name,customername,phone,email,nickname from contact")
    List<Contact> listAll();

    @Select("select id,name,customername,phone,email,nickname from contact where name=#{info} or phone=#{info} or email=#{info} or nickname=#{info}")
    List<Contact> selectByContactInfo(String info);
}
