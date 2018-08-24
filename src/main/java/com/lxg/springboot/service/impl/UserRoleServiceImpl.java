package com.lxg.springboot.service.impl;

import com.lxg.springboot.mapper.UserRoleRepository;
import com.lxg.springboot.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: UserRoleServiceImpl
 * @Description:
 * @Author GX
 * @Date 2018/06/11 上午 11:47
 * @Version V1.0
 */
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<String> findRoles(int uid) {
        return userRoleRepository.findRoleName(uid);
    }
}
