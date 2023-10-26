package com.Demo.service.impl;

import com.Demo.mapper.UserMapper;
import com.Demo.pojo.User;
import com.Demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
