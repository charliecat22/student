package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.mapper.UserMapper;
import com.student.pojo.User;
import com.student.service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;
	private String username;
	private String password;

	@RequestMapping("userLogin")
	public ModelAndView login(String username,String password){
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User getuser = userService.getUserByNameAndPassword(user);
		if(getuser!=null){
			mav.setViewName("success.jsp");
		}else{
			mav.setViewName("fail.jsp");
		}
		
		return mav;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
