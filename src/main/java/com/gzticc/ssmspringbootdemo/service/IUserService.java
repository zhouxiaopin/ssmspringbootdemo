package com.gzticc.ssmspringbootdemo.service;

import com.gzticc.ssmspringbootdemo.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> queryUser();
    User queryUserById(Long userId);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(Long userId);
}
