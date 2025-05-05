package com.example.Service_A.ServiceImpl;


import com.example.Service_A.ServiceInter.StudentServiceAServiceInterface;

import com.example.Service_A.dto.StudentDto;
import com.example.Service_A.entity.StudentEntity;
import com.example.Service_A.repository.StudentRespositoryServiceA;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceAServiceImpl implements StudentServiceAServiceInterface {


	@Autowired
	StudentRespositoryServiceA studentRespository;


	@Autowired
	ModelMapper modelMapper;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	ObjectMapper objectMapper;

	public StudentDto saveStudent(StudentDto studentDto) {

		log.info("Starting student save operation for: {}", studentDto);

		studentDto =  convertEntityToDto(studentRespository.save(convertDtoToEntity(studentDto)));

		log.info("Student entity saved to database: {}", studentDto);

		try {
			String Key=String.valueOf(studentDto.getStudentRollNumber());

			kafkaTemplate.send("Student_Service",Key,objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentDto));

			log.info("Published Student to Kafka with key {}: {}", Key, studentDto);

		}catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Completed Student save operation for: {}", studentDto);

		return studentDto;
	}

	public StudentDto convertEntityToDto(StudentEntity studentEntity) {
		return modelMapper.map(studentEntity, StudentDto.class);
	}
	public StudentEntity convertDtoToEntity(StudentDto studentDto) {
		return modelMapper.map(studentDto, StudentEntity.class);
	}


}
