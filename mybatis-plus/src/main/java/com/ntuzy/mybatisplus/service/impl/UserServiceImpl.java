package com.ntuzy.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ntuzy.mybatisplus.entity.User;
import com.ntuzy.mybatisplus.mapper.UserMapper;
import com.ntuzy.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

//    @Resource
//    private UserMapper userMapper;

    @Override
    public List<User> selectAllByName(String name) {
//        return userMapper.selectAllByName(name);
        return baseMapper.selectAllByName(name);
    }
}
