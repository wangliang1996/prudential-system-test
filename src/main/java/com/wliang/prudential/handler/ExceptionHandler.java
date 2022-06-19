package com.wliang.prudential.handler;

import com.wliang.prudential.exception.BusinessException;
import com.wliang.prudential.common.WrapperResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public WrapperResponse handleException(Exception e){
        if(e instanceof BusinessException){
            BusinessException myException =(BusinessException)e;
            return WrapperResponse.fail( myException.getCode(),myException.getMessage());
        }else {
            System.out.println("system error "+e.getMessage());
            return WrapperResponse.fail(e.getMessage());
        }
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public WrapperResponse handleBusinessException(BusinessException e){
        return WrapperResponse.fail(e.getCode(),e.getMsg());
    }
}
