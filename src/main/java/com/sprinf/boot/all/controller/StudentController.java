package com.sprinf.boot.all.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprinf.boot.all.bean.StudentBean;
import com.sprinf.boot.all.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	public StudentService service;

	@GetMapping(value = "/hello")
	public String greeting() {
		return "hello Spring boot";

	}

	@RequestMapping("/testuser")
	public String greetings(@RequestParam("userID") String userID) {
		return "hello again   " + userID;

	}

	@RequestMapping("/greet/{userid}/{coursename}")
	public String greet(@RequestParam("userid") String userid, @RequestParam("coursename") String coursename) {
		return userid + "hi there..." + coursename;

	}

	@RequestMapping(value = "/api/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public StudentBean insertStudent(@RequestBody StudentBean bean) {

		service.insert(bean);
		return bean;
	}

}