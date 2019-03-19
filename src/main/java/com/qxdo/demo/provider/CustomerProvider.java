package com.qxdo.demo.provider;

import com.qxdo.demo.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.time.LocalDateTime;

public class CustomerProvider {

    public String saveCustomer(@Param("customer")Customer customer){
        return new SQL(){
            {
                INSERT_INTO("customer");

                if(customer.getPhone()!= null ){
                    VALUES("phone","#{customer.phone}");
                }
                if(customer.getEmail()!= null ){
                    VALUES("email","#{customer.email}");
                }

                if(customer.getCompanyname()!= null ){
                    VALUES("companyname","#{customer.companyname}");
                }

                if(customer.getName()!= null ){
                    VALUES("name","#{customer.name}");
                }

                if(customer.getDesc()!= null ){
                    VALUES("desc","#{customer.desc}");
                }

                if(customer.getImcount()!= null ){
                    VALUES("imcount","#{customer.imcount}");
                }
                if(customer.getTypeid()!= null  ){

                    VALUES("typeid","#{customer.typeid}");
                }

                if(customer.getDeleted() != null){
                    //deleted 为 0
                    VALUES("deleted","#{customer.deleted}");//
                }
                if(customer.getDeleted() != null){
                    VALUES("modifiedtime", "#{customer.modifiedtime}");
                }
                if(customer.getUrl()!=null){
                    VALUES("url","#{customer.url}");
                }

            }
        }.toString();
    }

    public String updateCustomer(@Param("customer")Customer customer){
        return new SQL(){
            {
                UPDATE("customer");

                if(customer.getPhone()!= null ){
                    SET("phone = #{customer.phone}");
                }
                if(customer.getEmail()!= null ){
                    SET("email = #{customer.email}");
                }

                if(customer.getCompanyname()!= null ){
                    SET("companyname = #{customer.companyname}");
                }

                if(customer.getName()!= null ){
                    SET("name = #{customer.name}");
                }

                if(customer.getDesc()!= null ){
                    SET("desc = #{customer.desc}");
                }

                if(customer.getImcount()!= null ){
                    SET("imcount = #{customer.imcount}");
                }
                if(customer.getTypeid() != null ){
                    SET("typeid = #{customer.typeid}");
                }
                if(customer.getDeleted() != null){
                    //deleted 为 0
                    SET("deleted = #{customer.deleted}");//
                }
                if(customer.getDeleted() != null){
                    SET("modifiedtime = #{customer.modifiedtime}");
                }
                if(customer.getUrl()!=null){
                    SET("url = #{customer.url}");
                }


                WHERE("id=#{customer.id} and deleted=0");
            }
        }.toString();
    }
}
