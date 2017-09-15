package com.student.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.format.InputAccessor.Std;
import com.student.pojo.Student;
import com.student.pojo.UploadedImageFile;
import com.student.pojo.User;
import com.student.service.StudentService;
import com.student.util.Page;


@Controller
@RequestMapping("")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	
	public String name;
	public String sex;
	public String cid;
	public int uid;
	public String iid;
	public int id;
	public String keyword;
	public User user;
	
	
	@RequestMapping("listStudent")
	public ModelAndView listStudent(Page page,User user,Map<String , Object> map){
		ModelAndView mav = new ModelAndView();
		map.put("user", user);
		if(user.getRole()==2){
			int id=user.getId();
			List<Student> ls = studentService.listById(id);
			mav.addObject("cs",ls);
			mav.setViewName("listStudent.jsp?");
			return mav;
		}else{
		
		int total = studentService.total();	
		page.caculateLast(total);
		if(page.getStart()<=0){
			page.setStart(0);
		}
		if(page.getStart()>=page.getLast()){
			page.setStart(page.getLast());
		}
		List<Student> ls = studentService.list(page);
		mav.addObject("cs", ls);
		mav.setViewName("listStudent.jsp?");
		return mav;
		}
	}
	
	
	
	
	
	@RequestMapping(value="searchUser",produces = "text/html;charset=UTF-8")
	public ModelAndView search(String keyword){
		ModelAndView mav = new ModelAndView();
		List<Student> ls = studentService.search(keyword);
		mav.addObject("cs",ls);
		mav.setViewName("listStudent.jsp");
		return mav;
	}

	@RequestMapping("addUserInfo")
	public String add(int uid,String name,String sex,String cid,String iid,HttpServletRequest request,UploadedImageFile file,User user)
	throws IllegalStateException, IOException{
		  ModelAndView mav = new ModelAndView();
		  String newFileName = "/"+new Date().getTime()+".jpg";
		  File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
	      newFile.getParentFile().mkdirs();
	      file.getImage().transferTo(newFile);
	      String path = "/image"+newFileName;
	      Student st = new Student();
	      st.setName(name);
	      st.setSex(sex);
	      st.setImg(path);
	      st.setCid(cid);
	      st.setIid(iid);
	      st.setUid(uid);
	      studentService.add(st);
	      
	      
	      return "redirect:/login.jsp";
	}
	
	@RequestMapping("editUserInfo")
	public ModelAndView edit(Student student,Map<String, Object> map){
		
		ModelAndView mav = new ModelAndView();
		student=studentService.get(student);
		map.put("student",student);
		mav.setViewName("editUser.jsp");
		return mav;
		
	}
	
	@RequestMapping("editScore")
	public ModelAndView editScore(Student student,Map<String, Object> map){
		ModelAndView mav = new ModelAndView();
		student = studentService.get(student);
		map.put("student", student);
		mav.setViewName("courseScore.jsp");
		return mav;
	}
	
	@RequestMapping("updateUserInfo")
	public String update(String name,String cid,String iid,int id,UploadedImageFile file,HttpServletRequest request,MultipartFile image) 
			throws IllegalStateException, IOException{
		Student student = new Student();
		
		if(!file.getImage().isEmpty()){
		  String newFileName = "/"+new Date().getTime()+".jpg";
		  File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
	      newFile.getParentFile().mkdirs();
	      file.getImage().transferTo(newFile);
	      String path = "/image"+newFileName;
	      student.setImg(path);
		}
		
		student.setId(id);
		student.setName(name);
		student.setCid(cid);
		student.setIid(iid);
		
		studentService.update(student);
		return "redirect:/listStudent";
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getIid() {
		return iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}


	
	
	
}
