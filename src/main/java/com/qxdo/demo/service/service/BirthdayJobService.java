package com.qxdo.demo.service.service;

public interface BirthdayJobService {

    /**
     * 每天凌晨0:5分检查所有user，若有用户当天生日，则产生message
     */

    void cronBirthdayMessage();

}
