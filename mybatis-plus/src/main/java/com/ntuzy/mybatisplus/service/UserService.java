package com.ntuzy.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ntuzy.mybatisplus.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> selectAllByName(String name);
}
