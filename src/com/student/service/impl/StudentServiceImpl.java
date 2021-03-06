package com.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.mapper.StudentMapper;
import com.student.pojo.Student;
import com.student.service.StudentService;
import com.student.util.Page;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentMapper studentMapper;

	@Override
	public List<Student> list() {
		return studentMapper.list();
	}

	@Override
	public int total() {
		
		return studentMapper.total();
	}

	@Override
	public List<Student> list(Page page) {
		
		return studentMapper.list(page);
	}

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		studentMapper.add(student);
	}

	@Override
	public Student get(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.get(student);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentMapper.update(student);
	}

	@Override
	public List<Student> search(String keyword) {
		return studentMapper.search(keyword);
	}

	@Override
	public List<Student> listById(int id) {
		// TODO Auto-generated method stub
		return studentMapper.listById(id);
	}

}
