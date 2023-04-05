package com.jsp.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.student.dto.Student;
import com.jsp.student.util.HelperClass;

public class StudentDao {
	HelperClass helperClass = new HelperClass();

	public Student saveStudent(Student student) {

		Connection connection = helperClass.getConnection();
		String sql = "insert into student values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());

			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	public boolean deleteStudentById(int id) {


		Connection connection = helperClass.getConnection();
		String sql = "Delete from student where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;

	}
	
	public Student updateStudent(Student student) {
		Connection connection= helperClass.getConnection();
		String sql="update student set name=?,email=? where id=?";
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setInt(3, student.getId());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
		
	}
	
	

	public void getAllStudent() {
		Connection connection = helperClass.getConnection();
		String sql = "select * from student";

		try {
			// Create Statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// execute Statement
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("============================================");
				System.out.println("Student ID    : " + resultSet.getInt(1));
				System.out.println("Student Name  : " + resultSet.getString(2));
				System.out.println("Student Email : " + resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Close Connection
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void getById(int id) {
	Connection connection=	helperClass.getConnection();
	String sql="select * from student where id=?";
	
	try {
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		
	ResultSet resultSet=	preparedStatement.executeQuery();
	while(resultSet.next()) {
		System.out.println(resultSet.getInt(1));
		System.out.println(resultSet.getString(2));
		System.out.println(resultSet.getString(3));
	}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	}

}
