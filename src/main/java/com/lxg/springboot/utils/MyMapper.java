package com.lxg.springboot.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description: 继承自己的MyMapper
 * @Author GX
 * @Date 2018/08/22 下午 04:50
 * @Version V1.0
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
