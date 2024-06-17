package com.microservicio.backendspring.service;


import com.microservicio.backendspring.dto.CreatePumpDto;
import com.microservicio.backendspring.dto.ResponsePumpDto;
import com.microservicio.backendspring.model.Bomba;
import com.microservicio.backendspring.model.Tanque;
import com.microservicio.backendspring.repository.PumpRepository;
import com.microservicio.backendspring.repository.TankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BombaService {

    @Autowired
    private PumpRepository pumpRepository;

    @Autowired
    private TankRepository tankRepository;

    public List<ResponsePumpDto>  findAll(){
        List<Bomba> bombas = pumpRepository.findAll();
        List<ResponsePumpDto> pumpDtos = new ArrayList<>();
        bombas.forEach( bomba -> {
            ResponsePumpDto responsePumpDto = new ResponsePumpDto(bomba.getId().toString(), bomba.getName(),
                    bomba.getDescription(), bomba.getFuel_type(), bomba.getTanque() != null ? bomba.getTanque().getName() : null,
                    bomba.getStatus());
            pumpDtos.add(responsePumpDto);
        });
        return pumpDtos;
    }
    public ResponsePumpDto createBomba(CreatePumpDto pumpDto){
        Tanque tanque = tankRepository.findTanqueByName(pumpDto.tank()).orElse(null);
        Bomba bomba = Bomba.builder().name(pumpDto.name()).description(pumpDto.description())
                .fuel_type(pumpDto.fuel_type()).status(pumpDto.status()).tanque(tanque).build();
        Bomba saveBomba = pumpRepository.save(bomba);
        return new ResponsePumpDto(saveBomba.getId().toString(), saveBomba.getName(), saveBomba.getDescription(), saveBomba.getFuel_type(),
                saveBomba.getTanque() != null ? saveBomba.getTanque().getName() : null, saveBomba.getStatus());
    }
}
