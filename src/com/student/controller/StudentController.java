package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.pojo.Student;
import com.student.service.StudentService;
import com.student.util.Page;

@Controller
@RequestMapping("")
public class StudentController {
	@Autowired
	StudentService studentService;
	
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
		mav.setViewName("listStudent");
		
		return mav;
	}
}
