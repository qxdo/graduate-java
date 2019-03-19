package com.qxdo.demo;

import org.apache.tomcat.jni.Local;
import org.junit.Test;

import java.time.LocalDateTime;

public class TestSQL {
    @Test
    public void test(){
        LocalDateTime time = LocalDateTime.of(2018,1,1,1,1,1,1);

        sql("123","and",1,"or",time,LocalDateTime.now());


    }
    public void sql(String username,String operator1, Integer sex,String operator2, LocalDateTime from, LocalDateTime to){
        StringBuffer sb = new StringBuffer();
        if(null!= username){
            sb.append("username=#{username}");
        }

        if(null != sex){
            sb.append(" "+operator1+" ");
            sb.append("sex=#{sex}");
        }
        if(null != from && null != to){
            sb.append(" "+operator2+" ");
            sb.append("modifiedtime between #{from} and #{to}");
        }

        String sql= sb.toString();
        System.out.println(sql);

    }
}
