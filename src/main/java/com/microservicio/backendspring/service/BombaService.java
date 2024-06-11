package com.microservicio.backendspring.service;


import com.microservicio.backendspring.dto.CreatePumpDto;
import com.microservicio.backendspring.dto.ResponsePumpDto;
import com.microservicio.backendspring.model.Bomba;
import com.microservicio.backendspring.repository.PumpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BombaService {

    @Autowired
    private PumpRepository pumpRepository;

    public List<ResponsePumpDto>  findAll(){
        List<Bomba> bombas = pumpRepository.findAll();
        List<ResponsePumpDto> pumpDtos = new ArrayList<>();
        bombas.forEach( bomba -> {
            ResponsePumpDto responsePumpDto = new ResponsePumpDto(bomba.getId().toString(),
                    bomba.getName(), bomba.getDescription(), bomba.getFuel_type());
            pumpDtos.add(responsePumpDto);
        });
        return pumpDtos;
    }
    public ResponsePumpDto createBomba(CreatePumpDto pumpDto){
        Bomba bomba = Bomba.builder().name(pumpDto.name()).description(pumpDto.description())
                .fuel_type(pumpDto.fuel_type()).status(1).build();
        Bomba saveBomba = pumpRepository.save(bomba);
        return new ResponsePumpDto(bomba.getId().toString(), bomba.getName(),
                bomba.getDescription(), bomba.getFuel_type());
    }
}
