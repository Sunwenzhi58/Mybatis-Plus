package com.atuguigu.mybatisplus.service.impl;

import com.atuguigu.mybatisplus.mapper.UserMapper;
import com.atuguigu.mybatisplus.pojo.User;
import com.atuguigu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
