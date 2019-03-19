package com.qxdo.demo.exception;

import com.qxdo.demo.common.Result;
import com.qxdo.demo.util.ResultTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeParseException;


@ControllerAdvice
public class MyExceptionAdvice {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex) {

        logger.info("错误异常:" +ex.getClass()+ ex.getClass().getName());
        logger.info(ex.getMessage());
        /*if(ex.getClass().equals(NullPointerException.class)){
            return ResultTool.ERROR(ExceptionEnum.UNKNOWN_ERROR);
        }

        if(ex.getClass().equals(MissingServletRequestParameterException.class)){
            return ResultTool.ERROR(ExceptionEnum.DATA_NULL);
        }
        if(ex.getClass().equals(ConversionFailedException.class) || ex.getClass().equals(DateTimeParseException.class) ){
            return ResultTool.ERROR(ExceptionEnum.UNSUPPORTDATE);
        }*/


        ExceptionInfo exinfo = new ExceptionInfo(-1,ex.getMessage());
        return ResultTool.ERROR(exinfo);
    }

}
