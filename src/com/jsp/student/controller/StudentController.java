package com.jsp.student.controller;

import com.jsp.student.dao.StudentDao;
import com.jsp.student.dto.Student;

public class StudentController {
	public static void main(String[] args) {
		Student s1=new Student();
		s1.setId(4);
		s1.setName("abc");
		s1.setEmail("abc@gmail.com");
		
		StudentDao studentDao=new StudentDao();
		Student student= studentDao.saveStudent(s1);
		if(student!=null) {
			System.out.println(student.getName()+" added successfully");
		}
		
	}

}
