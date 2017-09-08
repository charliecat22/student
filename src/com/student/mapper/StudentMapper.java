package com.student.mapper;

import java.util.List;

import com.student.pojo.Student;
import com.student.util.Page;

public interface StudentMapper {
	
	public void add(Student student);
	public void delete(int id);
	
	public Student get(Student student);
	public void update(Student student);
	
	public int count();
	public List<Student> list();
	
	public int total();
	public List<Student> list(Page page);
	
}
