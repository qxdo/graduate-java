package com.qxdo.demo.provider;

import com.qxdo.demo.entity.Message;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class MessageProvider {
    public String saveMessage(@Param("message") Message message){
        return new SQL(){
            {
                INSERT_INTO("message");
                if(message.getMessage() != null){
                    VALUES("message","#{message.message}");
                }
                if(message.getModifiedtime() != null){
                    VALUES("modifiedtime","#{message.modifiedtime}");
                }

                if(null != message.getUser() && message.getUser().getId()!=null ){
                    VALUES("userid","#{message.user.id}");
                }
            }
        }.toString();
    }
}
