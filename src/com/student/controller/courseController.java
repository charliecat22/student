package com.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.pojo.Student;
import com.student.pojo.StudentInfo;
import com.student.service.CourseScoreService;
import com.student.service.StudentService;

@Controller
@RequestMapping("")
public class courseController {
	@Autowired
	CourseScoreService courseScoreService;
	@Autowired
	StudentService studentService;
	
	private int score1;
	private int score2;
	private int score3;
	private String cid1;
	private String cid2;
	private String cid3;
	private int uid;
	
	
	@RequestMapping("saveScore")
	public String addScore(int score1,int score2,int score3,String cid1,String cid2,String cid3,int uid){
		
		List<StudentInfo> ls = new ArrayList<StudentInfo>();
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setScore(score1);
		studentInfo.setCid(cid1);
		studentInfo.setUid(uid);
		ls.add(studentInfo);
		
		StudentInfo studentInfo1 = new StudentInfo();
		studentInfo1.setScore(score2);
		studentInfo1.setCid(cid2);
		studentInfo1.setUid(uid);
		ls.add(studentInfo1);
		
		StudentInfo studentInfo2 = new StudentInfo();
		studentInfo2.setScore(score3);
		studentInfo2.setCid(cid3);
		studentInfo2.setUid(uid);
		ls.add(studentInfo2);
		
		
		courseScoreService.addScore(ls);
		
		return "redirect:/listStudent";
	}
	
	
	@RequestMapping("checkScore")
	public ModelAndView list(Student student,Map<String, Object> map){
		ModelAndView mav = new ModelAndView();
		student = studentService.get(student);
		map.put("student",student);
		uid = student.getId();
		StudentInfo studentInfo =new StudentInfo();
		studentInfo.setUid(uid);
		List<StudentInfo> ls = courseScoreService.list(studentInfo);
		mav.addObject("cs",ls);
		mav.setViewName("checkStudentScore.jsp");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	public int getScore3() {
		return score3;
	}
	public void setScore3(int score3) {
		this.score3 = score3;
	}
	public String getCid1() {
		return cid1;
	}
	public void setCid1(String cid1) {
		this.cid1 = cid1;
	}
	public String getCid2() {
		return cid2;
	}
	public void setCid2(String cid2) {
		this.cid2 = cid2;
	}
	public String getCid3() {
		return cid3;
	}
	public void setCid3(String cid3) {
		this.cid3 = cid3;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
}
