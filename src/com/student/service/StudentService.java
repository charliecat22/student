package com.student.service;

import java.util.List;

import com.student.pojo.Student;
import com.student.util.Page;

public interface StudentService {
	List<Student> list();
	int total();
	List<Student> list(Page page);
}
