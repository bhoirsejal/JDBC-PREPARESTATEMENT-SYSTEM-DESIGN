package com.jsp.student.controller;

import com.jsp.student.dao.StudentDao;

public class StudentDelete {
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();
		boolean flag=studentDao.deleteStudentById(4);
		if(flag==true) {
			System.out.println("Record deleted");
		}
		else {
			System.out.println("Record is not deleted");
		}
	}

}
