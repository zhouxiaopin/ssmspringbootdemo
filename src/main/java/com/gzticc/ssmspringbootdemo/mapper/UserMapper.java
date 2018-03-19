package com.gzticc.ssmspringbootdemo.mapper;

import com.gzticc.ssmspringbootdemo.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> queryUser();
    User queryUserById(Long userId);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(Long userId);
}
