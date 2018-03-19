package com.gzticc.ssmspringbootdemo.service.impl;

import com.gzticc.ssmspringbootdemo.mapper.UserMapper;
import com.gzticc.ssmspringbootdemo.pojo.User;
import com.gzticc.ssmspringbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> queryUser() {
        return userMapper.queryUser();
    }

    @Override
    public User queryUserById(Long userId) {
        return userMapper.queryUserById(userId);
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
//        @Transactional(rollbackFor = Exception.class)
//        @Transactional 默认回滚RuntimeException
        if(null != user.getUserName() && !"".equals(user.getUserName())) {
            try {
                int effectedNum = userMapper.addUser(user);
                if(effectedNum > 0) {
                    return true;
                }else {
                    throw new RuntimeException("插入用户信息失败");
                }
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("插入用户信息失败:"+e.getMessage());
            }

        }else {
            throw new RuntimeException("用户名不能为空");
        }
    }

    @Transactional
    @Override
    public boolean updateUser(User user) {
        if(null != user.getUserId() && user.getUserId() > 0) {
            try {
                int effectedNum = userMapper.updateUser(user);
                if(effectedNum > 0) {
                    return true;
                }else {
                    throw new RuntimeException("修改用户信息失败");
                }
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("修改用户信息失败:"+e.getMessage());
            }

        }else {
            throw new RuntimeException("用户ID不能为空或者小于1");
        }
    }

    @Transactional
    @Override
    public boolean deleteUser(Long userId) {
        if(null != userId && userId > 0) {
            try {
                int effectedNum = userMapper.deleteUser(userId);
                if(effectedNum > 0) {
                    return true;
                }else {
                    throw new RuntimeException("删除用户信息失败");
                }
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("删除用户信息失败:"+e.getMessage());
            }

        }else {
            throw new RuntimeException("用户ID不能为空或者小于1");
        }
    }
}
