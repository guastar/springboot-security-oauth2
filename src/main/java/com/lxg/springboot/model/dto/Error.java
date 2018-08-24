package com.lxg.springboot.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: Error
 * @Description: 模型类 DTO（Data Trasfer Object）类
 * @Author GX
 * @Date 2018/06/25 下午 02:29
 * @Version V1.0
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Error implements Serializable {
    private static final long serialVersionUID = 7660756960387438399L;

    private int code; // Error code
    private String message; // Error message
}
