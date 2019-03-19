package com.qxdo.demo;

import org.junit.Test;

import java.time.LocalDate;

public class TestBirthday {
    @Test
    public void test(){
        LocalDate date = LocalDate.of(2018,3,2);//生日
        LocalDate now = LocalDate.of(2019,3,2);//现在的时间
        /*System.out.println("几号:"+ date.getDayOfMonth());//几号
        System.out.println("几月:"+ date.getMonth().getValue());*/

        if( (date.getMonth().getValue() - now.getMonth().getValue() == 0) && (date.getDayOfMonth() - now.getDayOfMonth() == 0) ){
            System.out.println("今天是您生日");
        }else{
            System.out.println("离您生日还早");
        }




    }
}
