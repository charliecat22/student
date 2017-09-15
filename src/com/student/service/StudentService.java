package com.student.service;

import java.util.List;

import com.student.pojo.Student;
import com.student.util.Page;

public interface StudentService {
	public List<Student> list();
	public int total();
	public List<Student> list(Page page);
	public void add(Student student);
	
	public Student get(Student student);
	public void update(Student student);
	
	public List<Student> search(String keyword);
	
	public List<Student> listById(int id);
}
