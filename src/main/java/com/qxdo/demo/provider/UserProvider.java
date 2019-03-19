package com.qxdo.demo.provider;

import com.qxdo.demo.entity.User;
import com.sun.xml.internal.ws.client.sei.ValueSetter;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLOutput;
import java.time.LocalDateTime;

public class UserProvider {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String saveUser(@Param("user") User user){
        return  new SQL(){
            {
                INSERT_INTO("user");
                if(user.getAddress()!= null){
                    VALUES("address","#{user.address}");
                }
                if(user.getBackup()!= null){
                    VALUES("backup","#{user.backup}");
                }
                if(user.getContact()!= null){
                    VALUES("contact","#{user.contact}");
                }
                if(user.getDeleted()!= null){
                    VALUES("deleted","#{user.deleted}");
                }
                if(user.getSex()!= null){
                    VALUES("sex","#{user.sex}");
                }
                if(user.getBirthday()!= null){
                    VALUES("birthday","#{user.birthday}");
                }
                if(user.getLevele()!= null){
                    VALUES("levele","#{user.levele}");
                }
                if(user.getModifiedtime()!= null){
                    VALUES("modifiedtime","#{user.modifiedtime}");
                }
                if(user.getUsername()!= null){
                    VALUES("username","#{user.username}");
                }
            }
        }.toString();

    }

    public String selectbymuticondication(@Param("username") String username,
                                          @Param("operator1")String operator1,
                                          @Param("sex") Integer sex,
                                          @Param("operator2")String operator2,
                                          @Param("from") LocalDateTime from,
                                          @Param("to") LocalDateTime to){
        logger.info("selectbymuticondication");


        return new SQL(){
            {
                // and sex=#{sex} and modifiedtime between #{from} and #{to}
                SELECT("id,username,sex,birthday,address,contact,levele,modifiedtime,backup,deleted");
                FROM("user");
                StringBuffer sb = new StringBuffer();
                if(null!= username){
                    sb.append("username=#{username}");
                }

                if(null != sex){
                    if(null != operator1){
                        sb.append(" "+operator1+" ");
                    }
                    sb.append("sex=#{sex}");
                }
                if(null != from && null != to){
                    if(null != operator2){
                        sb.append(" "+operator2+" ");
                    }

                    sb.append("modifiedtime between #{from} and #{to}");
                }
                sb.append(" and deleted=0");
                System.out.println(sb.toString());
                WHERE(sb.toString());
            }
        }.toString();

    }
    public String updateUser(@Param("user") User user){
        return  new SQL(){
            {
                UPDATE("user");
                if(user.getAddress()!= null){
                    SET("address = #{user.address}");
                }
                if(user.getBackup()!= null){
                    SET("backup = #{user.backup}");
                }
                if(user.getContact()!= null){
                    SET("contact = #{user.contact}");
                }
                if(user.getDeleted()!= null){
                    SET("deleted = #{user.deleted}");
                }
                if(user.getSex()!= null){
                    SET("sex = #{user.sex}");
                }
                if(user.getBirthday()!= null){
                    SET("birthday = #{user.birthday}");
                }
                if(user.getLevele()!= null){
                    SET("levele = #{user.levele}");
                }
                if(user.getModifiedtime()!= null){
                    SET("modifiedtime = #{user.modifiedtime}");
                }
                if(user.getUsername()!= null){
                    SET("username = #{user.username}");
                }
                WHERE("id=#{user.id} and deleted=0");
            }
        }.toString();

    }
}
