package com.example.Service_A.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_A.ServiceInter.BikeServiceAServiceInterface;
import com.example.Service_A.dto.BikeDtoA;

@RestController
public class BikeControllerServiceA {
	
	@Autowired
	BikeServiceAServiceInterface bikeServiceAServiceInterface;
	
	
	@PostMapping("/saveBikeA")
	public BikeDtoA saveBikeA(@RequestBody BikeDtoA bikeDto) {
		 return bikeServiceAServiceInterface.saveBikeA(bikeDto);
	}

}
