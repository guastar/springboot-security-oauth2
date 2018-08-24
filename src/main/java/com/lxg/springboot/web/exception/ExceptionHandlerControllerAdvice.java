package com.lxg.springboot.web.exception;

import com.lxg.springboot.utils.ErrorCode;
import com.lxg.springboot.model.dto.Error;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ExceptionHandlerControllerAdvice
 * @Description:
 * @Author GX
 * @Date 2018/06/25 下午 02:25
 * @Version V1.0
 */
@CommonsLog
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(HttpServletRequest request, ResourceNotFoundException e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Error()
                        .setCode(ErrorCode.RESOURCE_NOT_FOUND_ERROR)
                        .setMessage(e.getMessage()));
    }

    @ExceptionHandler(ParameterIllegalException.class)
    public ResponseEntity<?> parameterIllegalExceptionHandler(HttpServletRequest request, ParameterIllegalException e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new Error()
                        .setCode(ErrorCode.PARAMETER_ILLEGAL_ERROR)
                        .setMessage("An invalid value was specified for one of the query parameters in the request URL."));
    }

    @ExceptionHandler(ServerInternalErrorException.class)
    public ResponseEntity<?> serverInternalErrorExceptionHandler(HttpServletRequest request, ServerInternalErrorException e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Error()
                        .setCode(ErrorCode.RESOURCE_NOT_FOUND_ERROR)
                        .setMessage("The server encountered an internal error. Please retry the request."));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(HttpServletRequest request, Exception e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Error()
                        .setCode(ErrorCode.SERVER_INTERNAL_ERROR)
                        .setMessage("The server met an unexpected error. Please contact administrators."));
    }

    /********************************** HELPER METHOD **********************************/
    private void logError(HttpServletRequest request, Exception e) {
        log.error("[URI: " + request.getRequestURI() + "]"
                + "[error: " + e.getMessage() + "]");
    }
}
