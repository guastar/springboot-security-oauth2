package com.lxg.springboot;

import com.lxg.springboot.model.entity.User;
import com.lxg.springboot.mapper.UserRepository;
import com.lxg.springboot.mapper.UserRoleRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Test
    public void contextLoads() {
        //User user = userRepository.findByUsername("123");
        //List<UserRole> userRole = userRoleRepository.findByuid(1);


        List<String> list = userRoleRepository.findRoleName(1);
        System.out.println(list.get(0));
    }

    @Test
    public void testfindByNameAndPassword(){
        userRepository.findByNameAndPassword("王大帅", "123");
    }

    @Test
    public void testFindByNameAndEmail(){
        userRepository.findByNameAndEmail("张大仙", "2@qq.com");
    }

    @Test
    public void testFindByNameLike(){
        List<User> users = userRepository.findByNameLike("马");
        //logger.info(users.size() + "----");
    }

    @Test
    public void testFindByCreateDateBetween() throws Exception{
        List<User> users = userRepository.findByCreateDateBetween(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-01-01 00:00:00"), new Date(System.currentTimeMillis()));
        //logger.info(users.size() + "----");
    }

    @Test
    public void testFindByNameIn(){
        List<String> list = new ArrayList<String>();
        list.add("王大帅");
        list.add("李小三");
        userRepository.findByNameIn(list);
    }

    @Test
    public void testfindByNameAndPasswordEntity(){
        User u = new User();
        u.setUsername("李小三");
        u.setPassword("444");
        userRepository.findByNameAndPassword(u);
    }

    @Test
    public void testFindAllPage() throws Exception {
        Pageable pageable = new PageRequest(0,5);
        Page<User> page = userRepository.findAllPage(pageable);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(page);
        //logger.info(json);
    }
    @Test
    public void findByEmailLike(){
        Pageable pageable = new PageRequest(0,5,new Sort(Sort.Direction.ASC,"id"));
        userRepository.findByEmailLike(pageable, "@qq.com");
    }

}
