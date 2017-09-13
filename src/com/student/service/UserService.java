package com.student.service;

import com.student.pojo.User;

public interface UserService {
	public User getUserByNameAndPassword(User user);
	public void userRegister(User user);
}
