package com.qxdo.demo;

import com.qxdo.demo.dao.UserDao;
import com.qxdo.demo.entity.Charts;
import com.qxdo.demo.util.DateTimeTool;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestData extends DemoApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    public void test(){

        List<Charts> charst = userDao.selectpeerdayuserincreased();
        for(Charts chart: charst){

            System.out.println(chart.getData());
            System.out.println(chart.getTitle());
        }
    }
}
