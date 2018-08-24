package com.lxg.springboot.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: PaginatedResult
 * @Description:
 * @Author GX
 * @Date 2018/06/25 下午 03:04
 * @Version V1.0
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginatedResult implements Serializable {
    private static final long serialVersionUID = 6191745064790884707L;

    private int currentPage; // Current page number
    private int totalPage; // Number of total pages
    private Object data; // Paginated resources
}
