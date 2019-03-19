package com.qxdo.demo.service.impl;

import com.qxdo.demo.dao.UserDao;
import com.qxdo.demo.entity.Charts;
import com.qxdo.demo.service.service.ChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("chartsService")
public class ChartsServiceImpl implements ChartsService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<Charts> peerdayuserincreased() {

        return userDao.selectpeerdayuserincreased();

    }
}
