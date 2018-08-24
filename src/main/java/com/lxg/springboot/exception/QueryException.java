package com.lxg.springboot.exception;

/**
 * @Description: 查询异常
 * @Author GX
 * @Date 2018/08/22 上午 11:25
 * @Version V1.0
 */
public class QueryException extends Exception {
    public QueryException(String message) {
        super(message);
    }
}
