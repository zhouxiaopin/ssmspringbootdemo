package com.gzticc.ssmspringbootdemo.mapper;

import com.gzticc.ssmspringbootdemo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void queryUser() throws Exception {
        System.out.println(userMapper.queryUser());

    }

    @Test
    public void queryUserById() throws Exception {
        System.out.println(userMapper.queryUserById(2L));
    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUserName("aaa");
        user.setPassword("123456");
        userMapper.addUser(user);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setUserId(8L);
        user.setUserName("BBB");
        user.setPassword("123");
        userMapper.updateUser(user);
    }

    @Test
    public void deleteUser() throws Exception {
        userMapper.deleteUser(9L);
    }

}