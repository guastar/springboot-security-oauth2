package com.lxg.springboot.service.impl;

import com.lxg.springboot.model.dto.CustomUserDetails;
import com.lxg.springboot.model.entity.User;
import com.lxg.springboot.mapper.UserRepository;
import com.lxg.springboot.service.UserService;
import com.lxg.springboot.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author GX
 * @Date 2018/06/11 上午 11:45
 * @Version V1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return userRepository.selectUserByPage(offset, perPage);
    }

    @Override
    public Integer getTotalPage(Integer perPage) {
        //return PageUtil.calculateTotalPage(userRepository.selectCount(), perPage);
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find the user '" + username + "'");
        }

        // Not involve authorities, so pass null to authorities
        return new CustomUserDetails(user, true, true, true, true, null);
    }

    /**
     * 通过姓名获取用户信息
     * @param name 用户姓名
     * @return
     */
    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    /**
     * 获取所有用户列表
     * @return
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * 新增用户信息
     * @param user 用户信息
     * @return
     */
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findOne(id);
    }

    /**
     * 删除用户信息
     * @param id 主键Id
     */
    @Override
    public void deleteUserById(long id) {
        userRepository.delete(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return
     */
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    /**
     * 获取最新的用户
     * @return
     */
    @Override
    public List<User> getCurrentUserList() {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        return userRepository.findAll(sort);
    }

    /**
     * 获取分页的用户
     * @return
     */
    @Override
    public Page<User> getPageUserList() {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable = new PageRequest(0,5,sort);
        return userRepository.findAll(pageable);
    }
}
