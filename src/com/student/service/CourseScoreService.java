package com.student.service;

import java.util.List;

import com.student.pojo.StudentInfo;

public interface CourseScoreService {
	public void addScore(List<StudentInfo>	studentInfos);
	
	public List<StudentInfo> list(StudentInfo studentInfo);
}
