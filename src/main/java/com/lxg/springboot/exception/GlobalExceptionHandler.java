package com.lxg.springboot.exception;

import com.lxg.springboot.exception.QueryException;
import com.lxg.springboot.utils.Constant;
import com.lxg.springboot.utils.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 全局异常捕获，兼容 web 和 ajax, 使用 @ControllerAdvice 声明当前是助手类
 * @Author GX
 * @Date 2018/08/22 上午 11:16
 * @Version V1.0
 */
@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();

        if (isAjax(request)) {
            return this.responseByAjax(request, response, e);
        }
        return this.responseByWeb(request, response, e);
    }

    private boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null) && ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) ;
    }

    private JsonResult responseByAjax(HttpServletRequest request, HttpServletResponse response, Exception e) {
        return JsonResult.errException(e.getMessage());
    }

    private ModelAndView responseByWeb(HttpServletRequest request, HttpServletResponse response, Exception e) {
        ModelAndView model = new ModelAndView();
        if(e instanceof QueryException) {
            model.addObject("errorName","查询异常");
            model.addObject("message", e.getMessage());
            model.addObject("detail", Constant.ERROR_DETAIL);
        }else if(e instanceof ClassCastException) {
            model.addObject("errorName","404");
            model.addObject("message", "访问地址不存在，请确认URL地址是否正确");
            model.addObject("detail", e.getMessage());
        }else{
            model.addObject("errorName", e.getClass().getSimpleName());
            model.addObject("message", e.getMessage());
            model.addObject("detail", Constant.ERROR_DETAIL);
        }
        model.setViewName("base/error/error");
        return model;
    }
}
