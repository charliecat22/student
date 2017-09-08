package com.student.test;

import java.util.List;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.student.mapper.StudentMapper;
import com.student.pojo.Student;
import com.student.util.Page;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class Test {
	@Autowired
	private StudentMapper studentMapper;
	
	@org.junit.Test
	public void testAdd(){
		for(int i =0 ;i<100;i++){
			Student student = new Student();
			student.setName("testName"+i);
			studentMapper.add(student);
		}
	}
	
	@org.junit.Test
	public void testTotal() {
		int total = studentMapper.total();
		System.out.println(total);
	}
	
	@org.junit.Test
	public void testList(){
		Page p = new Page();
		p.setStart(3);
		p.setCount(10);
		List<Student> lis = studentMapper.list(p);
		for(Student s :lis){
			System.out.println(s.getName());
		}
	}
	
}
