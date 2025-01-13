package com.cjc.repository;

import java.util.List;

import com.cjc.model.Student;

public interface StudentRepository {

	public void saveStudent(Student student);

	public List<Student> getAllData();

	public List<Student> deleteData(int rollno);

	public Student getStudent(int rollno);

	public void updateStudent(Student student);
	
}
