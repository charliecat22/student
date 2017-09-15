package com.student.mapper;

import java.util.List;

import com.student.pojo.User;

public interface UserMapper {
	public void userRegister(User user);
	public User getUserByNameAndPassword(User user);
	public List<User> getUnExaminedUser();
	public void updateStatus(int id);
	
	public User getUserByNameAndPassword2(User user);
}
