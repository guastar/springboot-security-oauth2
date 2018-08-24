package com.lxg.springboot.utils;

/**
 * @ClassName: ErrorCode
 * @Description:
 * @Author GX
 * @Date 2018/06/25 下午 02:29
 * @Version V1.0
 */
public class ErrorCode {
    public static final int SERVER_INTERNAL_ERROR = 1000;
    public static final int PARAMETER_MISSING_ERROR = 1001;
    public static final int PARAMETER_ILLEGAL_ERROR = 1002;
    public static final int RESOURCE_NOT_FOUND_ERROR = 1003;

    /**
     * Prevent instantiation
     */
    private ErrorCode() {
    }
}
