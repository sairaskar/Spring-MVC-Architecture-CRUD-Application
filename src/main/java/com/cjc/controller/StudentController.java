package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.model.Student;
import com.cjc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/")
	public String landingPage() {
		System.out.println("Inside the Landing Page..!");
		return "index";
	}

	@RequestMapping(value = "/reg")
	public String regPage() {
		System.out.println("inside the Reg Page...!");
		return "register";
	}

	@RequestMapping(value = "/log")
	public String logPage() {
		System.out.println("insie the Log Page..!");
		return "login";
	}

	@RequestMapping(value = "/login")
	public String loginPage(@RequestParam String user, @RequestParam String pass, Model model) {
		System.out.println("username :" + user);
		System.out.println("password :" + pass);

		boolean valid = studentService.loginCheck(user, pass);

		if (valid) {

			List<Student> stuList = studentService.getAllData();

			model.addAttribute("data", stuList);

			return "success";
		}

		return "index";
	}

	@RequestMapping(value = "/register")
	public String registerPage(@ModelAttribute Student student) {
		System.out.println("In Controller layer :" + student);
		studentService.saveStudent(student);
		return "index";
	}

	@RequestMapping(value = "/delete")
	public String deleteData(@RequestParam int rollno, Model model) {

		System.out.println("IN Controller Layer :" + rollno);

		List<Student> stuList = studentService.deleteData(rollno);

		model.addAttribute("data", stuList);

		return "success";
	}

	@RequestMapping(value = "/edit")
	public String editData(@RequestParam int rollno, Model model) {
		System.out.println("In Controller Layer :" + rollno);

		Student student = studentService.getStudent(rollno);

		model.addAttribute("stud", student);

		return "edit";
	}

	@RequestMapping(value = "/update")
	public String updateData(@ModelAttribute Student student, Model model) {
		System.out.println("In Controller Layer :" + student);

		studentService.updateStudent(student);

		List<Student> stuList = studentService.getAllData();

		model.addAttribute("data", stuList);

		return "success";
	}

}

 