package com.student.mapper;

import com.student.pojo.User;

public interface UserMapper {
	public void addUser(User user);
	public User getUserByNameAndPassword(User user);
}