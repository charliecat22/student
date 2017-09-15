package com.student.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jcp.xml.dsig.internal.MacOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.pojo.User;
import com.student.service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;
	
	private String username;
	private String password;
	private int role;
	private int id;

	@RequestMapping("userLogin")
	public String login(String username,String password,Map<String, Object> map){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
	
		User getuser = userService.getUserByNameAndPassword(user);
		if(getuser!=null){
			return "redirect:/listStudent?id="+getuser.getId()+"&role="+getuser.getRole();
		}else{
			return "redirect:/fail.jsp";
		}
		
	}

	@RequestMapping("userRegister")
	public ModelAndView register(String username,String password,HttpServletRequest request){
		role = 2;
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		userService.userRegister(user);
		User getUserId =  userService.getUserByNameAndPassword2(user);
		request.setAttribute("user", getUserId);
		mav.setViewName("userInfoRegister.jsp?");
		return mav;	
	}
	
	@RequestMapping("UnExaminedUser")
	public ModelAndView listUnExaminedUser(){
		ModelAndView mav = new ModelAndView();
		List<User> ul = userService.getUnExaminedUser();
		mav.addObject("us",ul);
		mav.setViewName("unExamined.jsp");
		return mav;
	}
	
	
	@RequestMapping("examined")
	public String setStatud(int id){
		userService.updateStatus(id);
		return "redirect:/UnExaminedUser";
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
