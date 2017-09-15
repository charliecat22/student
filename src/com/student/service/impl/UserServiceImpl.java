package com.student.service.impl;

import java.util.List;

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

	@Override
	public List<User> getUnExaminedUser() {
		// TODO Auto-generated method stub
		return userMapper.getUnExaminedUser();
	}

	@Override
	public void updateStatus(int id) {
		userMapper.updateStatus(id);
		
	}

	@Override
	public User getUserByNameAndPassword2(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUserByNameAndPassword2(user);
	}

}
