package com.qxdo.demo.provider;


import com.qxdo.demo.entity.Contact;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class ContactProvider {
    public String updateContact(@Param("contact")Contact contact){
        return new SQL(){
            {
                UPDATE("contact");
                if(contact.getName() != null){
                    SET("name = #{contact.name}");
                }
                if(contact.getCustomername() != null){
                    SET("customername = #{contact.customername}");
                }
                if(contact.getPhone() != null){
                    SET("phone = #{contact.phone}");
                }
                if(contact.getEmail() != null){
                    SET("email = #{contact.email}");
                }
                if(contact.getNickname() != null){
                    SET("nickname = #{contact.nickname}");
                }
                WHERE("id=#{contact.id}");

            }


        }.toString();
    }
}
