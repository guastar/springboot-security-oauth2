package com.lxg.springboot.service;

import com.lxg.springboot.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description:
 * @Author GX
 * @Date 2018/06/11 上午 11:39
 * @Version V1.0
 */
public interface UserService extends UserDetailsService {
    User findByUsername(String name);

    List<User> findAll();

    void saveUser(User user);

    User findById(long id);

    void deleteUserById(long id);

    void deleteAllUsers();

    void updateUser(User user);

    List<User> getCurrentUserList();

    Page<User> getPageUserList();

    List<User> getUserByPage(Integer page, Integer perPage);
    Integer getTotalPage(Integer perPage);

}
