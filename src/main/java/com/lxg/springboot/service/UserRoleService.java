package com.lxg.springboot.service;

import java.util.List;

/**
 * @ClassName: UserRoleService
 * @Description:
 * @Author GX
 * @Date 2018/06/11 上午 11:39
 * @Version V1.0
 */
public interface UserRoleService {
    List<String> findRoles(int uid);
}
