package com.cjc.service;

import java.util.List;

import com.cjc.model.Student;

public interface StudentService {
	
	public void saveStudent(Student student);
	
	public boolean loginCheck(String username,String password);

	public List<Student> getAllData();

	public List<Student> deleteData(int rollno);

	public Student getStudent(int rollno);

	public void updateStudent(Student student);

}
