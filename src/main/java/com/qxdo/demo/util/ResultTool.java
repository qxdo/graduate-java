package com.qxdo.demo.util;

import com.qxdo.demo.common.Result;
import com.qxdo.demo.exception.CommonException;

/**
 * 返回请求的工具
 */
public class ResultTool {


    /**
     * status: 400 ERROR_发生异常情况返回的消息
     *
     * @param common
     * @return
     */
    public static Result ERROR(CommonException common){
        Result result = new Result();

        result.setMsg(common.getMessage());
        result.setData(null);
        result.setStatus(400);
        return result;

    }



    /**
     * status: 200 SUCCESS
     *
     * @return
     */

    public static Result SUCCESS(){
        Result result = new Result();
        result.setStatus(200);
        result.setData(null);
        result.setMsg("成功");
        return result;
    }

    /**
     * status: 201 SUCCESS_自定义返回消息
     * @param msg
     * @return
     */

    public static Result SUCCESS(String msg){
        Result result = new Result();
        result.setStatus(201);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }

    /**
     * status: 202 SUCCESS_可自定义返回数据
     * @param data
     * @return
     */

    public static Result SUCCESS(Object data){
        Result result = new Result();
        result.setStatus(202);
        result.setData(data);
        result.setMsg("成功");
        return result;
    }

    /**
     * status: 300 FAIL
     * @return
     */

    public static Result FAIL(){
        Result result = new Result();
        result.setStatus(300);
        result.setData(null);
        result.setMsg("失败");
        return result;
    }

    /**
     * status: 301 FAIL_可自定义信息
     * @param msg
     * @return
     */

    public static Result FAIL(String msg){
        Result result = new Result();
        result.setStatus(301);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }

    /**
     * status: _ 可自定义返回消息的状态，以及消息
     * @param status
     * @param msg
     * @return
     */

    public static Result FAIL(Integer status,String msg){
        Result result = new Result();
        result.setStatus(status);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }






}
