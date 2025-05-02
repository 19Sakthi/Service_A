package com.example.Service_A.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Service_A.ServiceInter.BikeServiceAServiceInterface;
import com.example.Service_A.dto.BikeDtoA;
import com.example.Service_A.entity.BikeEntityA;
import com.example.Service_A.repository.BikeRespositoryServiceA;

@Service
public class BikeServiceAServiceImpl implements BikeServiceAServiceInterface {
	
	
	@Autowired
	BikeRespositoryServiceA bikeRespositoryServiceA;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RestTemplate restTemplate;
	
	public BikeDtoA saveBikeA(BikeDtoA bikeDto) {	
		bikeRespositoryServiceA.save(convertDtoToEntity(bikeDto));
		return bikeDto;
	}
	
	public BikeDtoA convertEntityToDto(BikeEntityA bikeEntity) {
		return modelMapper.map(bikeEntity,BikeDtoA.class);
	}
	public BikeEntityA convertDtoToEntity(BikeDtoA bikeDto) {
		return modelMapper.map(bikeDto, BikeEntityA.class);
	}


}
