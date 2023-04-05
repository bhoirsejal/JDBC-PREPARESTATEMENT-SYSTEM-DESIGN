package com.jsp.student.controller;

import com.jsp.student.dao.StudentDao;
import com.jsp.student.dto.Student;

public class StudentUpdate {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setId(2);
		s1.setName("advaith");
		s1.setEmail("advaithkailasnegi@gmail.com");

		StudentDao studentDao = new StudentDao();
		Student student = studentDao.updateStudent(s1);
		if(student!=null) {
			System.out.println("record updated");
		}
		else System.out.println("record not found");
	}

}
