package com.cjc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.constants.Credentials;
import com.cjc.model.Student;
import com.cjc.repository.StudentRepository;
import com.cjc.repositoryimpl.StudentRepositoryImpl;
import com.cjc.service.StudentService;

@Service 
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public void saveStudent(Student student) {
		System.out.println("In Service Layer :" + student);
		studentRepository.saveStudent(student);
	}

	public boolean loginCheck(String username, String password) {

		if (Credentials.USERNAME.equalsIgnoreCase(username) && Credentials.PASSWORD.equals(password)) {
			return true;
		}

		return false;
	}

	public List<Student> getAllData() {

		List<Student> stuList = studentRepository.getAllData();

		return stuList;
	}

	public List<Student> deleteData(int rollno) {
		
		List<Student> stuList = studentRepository.deleteData(rollno);
		return stuList;
	}
	
	public Student getStudent(int rollno) {
		
		Student student=studentRepository.getStudent(rollno);
		
		return student;
	}
	public void updateStudent(Student student) {
		
		studentRepository.updateStudent(student);
		
	}
}
