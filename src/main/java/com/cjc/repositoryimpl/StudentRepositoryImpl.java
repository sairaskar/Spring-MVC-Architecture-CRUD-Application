package com.cjc.repositoryimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.model.Student;
import com.cjc.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private SessionFactory sf;

	public void saveStudent(Student student) {
		System.out.println("In Repository Layer :" + student);
		// save in DB
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
	}

	public List<Student> getAllData() {
		Session session = sf.openSession();
		Query query = session.createQuery("from Student");
		List<Student> list = query.getResultList();
		return list;
	}

	public List<Student> deleteData(int rollno) {

		Session session = sf.openSession();

		String hql = "delete from Student where rollno=" + rollno + " ";

		Transaction tx = session.beginTransaction();

		Query query = session.createQuery(hql);

		query.executeUpdate();

		tx.commit();

		return getAllData();
	}

	public Student getStudent(int rollno) {

		Session session = sf.openSession();

		Student student = session.get(Student.class, rollno);

		return student;
	}

	public void updateStudent(Student student) {

		Session session = sf.openSession();

		session.update(student);

		session.beginTransaction().commit();
	}

}
