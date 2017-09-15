package com.student.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.mapper.CourseScoreMapper;
import com.student.pojo.StudentInfo;
import com.student.service.CourseScoreService;


@Service
public class CourseScoreServiceImpl implements CourseScoreService{
	@Autowired
	CourseScoreMapper courseScoreMapper;


	@Override
	public void addScore(List<StudentInfo> studentInfos) {
		courseScoreMapper.addScore(studentInfos);
	}


	@Override
	public List<StudentInfo> list(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		return courseScoreMapper.list(studentInfo);
	}

}
