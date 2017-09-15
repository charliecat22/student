package com.student.mapper;

import java.util.List;

import com.student.pojo.StudentInfo;

public interface CourseScoreMapper {
	public void addScore(List<StudentInfo> studentInfos);
	
	public List<StudentInfo> list(StudentInfo studentInfo);
}
