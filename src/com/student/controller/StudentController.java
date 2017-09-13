package com.student.controller;

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

import com.student.pojo.Student;
import com.student.pojo.UploadedImageFile;
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
	public String uid;
	public String iid;
	public int id;
	
	@RequestMapping("listStudent")
	public ModelAndView listStudent(Page page){
		ModelAndView mav = new ModelAndView();
		
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
		mav.setViewName("listStudent.jsp");
		return mav;
	}

	@RequestMapping("addUserInfo")
	public String add(String name,String sex,String cid,String iid,HttpServletRequest request,UploadedImageFile file)
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
	      
	      studentService.add(st);
	      return "redirect:/listStudent";
	}
	
	@RequestMapping("editUserInfo")
	public ModelAndView edit(Student student,Map<String, Object> map){
		
		ModelAndView mav = new ModelAndView();
		student=studentService.get(student);
		map.put("student",student);
		mav.setViewName("editUser.jsp");
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getIid() {
		return iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}


	
	
	
}
