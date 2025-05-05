package com.example.Service_A.controller;

import com.example.Service_A.dto.StudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_A.ServiceInter.StudentServiceAServiceInterface;

@RestController
@Slf4j
public class StudentControllerServiceA {


	@Autowired
	StudentServiceAServiceInterface studentServiceInterface;


	@PostMapping("/saveStudent")
	public StudentDto saveStudent(@RequestBody StudentDto studentDto) {

		log.info("[SaveStudent Method] - in Service_AController with StudentDto - {}", studentDto);

		StudentDto savedStudentDto = studentServiceInterface.saveStudent(studentDto);

		log.info("Student saved successfully: {}", savedStudentDto);


		return savedStudentDto;
	}

}
