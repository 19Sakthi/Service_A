package com.example.Service_A.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Service_A.entity.StudentEntity;

public interface StudentRespositoryServiceA extends JpaRepository<StudentEntity, Integer>{

}
