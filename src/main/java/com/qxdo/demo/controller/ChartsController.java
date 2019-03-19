package com.qxdo.demo.controller;

import com.qxdo.demo.common.Result;

import com.qxdo.demo.entity.Charts;
import com.qxdo.demo.service.service.ChartsService;
import com.qxdo.demo.util.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/charts")
public class ChartsController {
    @Autowired
    private ChartsService chartsService;

    @GetMapping("/peerdayuserincreased")
    public Result peerDayUserIncreased(){

        List<Charts> charts = chartsService.peerdayuserincreased();
        if(null != charts && charts.size() > 0){
            return  ResultTool.SUCCESS(charts);
        }
        return ResultTool.FAIL();
    }


}
