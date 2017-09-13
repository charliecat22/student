package com.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.mapper.UserMapper;
import com.student.pojo.User;
import com.student.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	
	
	@Override
	public User getUserByNameAndPassword(User user) {
		
		return userMapper.getUserByNameAndPassword(user);
	}
	
	@Override
	public void userRegister(User user) {
		userMapper.userRegister(user);
	}

}
