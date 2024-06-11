package com.microservicio.backendspring.service;


import com.microservicio.backendspring.dto.CreateTankDto;
import com.microservicio.backendspring.dto.ResponseTankDto;
import com.microservicio.backendspring.model.Tanque;
import com.microservicio.backendspring.repository.TankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TanqueService {

    @Autowired
    private TankRepository tankRepository;

    public List<ResponseTankDto> findAll() {
        List<Tanque> tanques = tankRepository.findAll();
        List<ResponseTankDto> tankDtos = new ArrayList<>();
        tanques.forEach(tanque -> {
            ResponseTankDto responseTankDto = new ResponseTankDto(tanque.getId().toString(), tanque.getFuel_quantity(),
                    tanque.getCap_max(), tanque.getCap_min());
            tankDtos.add(responseTankDto);
        });
        return tankDtos;
    }
    public ResponseTankDto createTanque(CreateTankDto tankDto) {
        Tanque tanque = Tanque.builder().fuel_quantity(tankDto.fuel_quantity()).cap_max(tankDto.cap_max())
                .cap_min(tankDto.cap_min()).status(1).build();
        Tanque savedTanque = tankRepository.save(tanque);
        return new ResponseTankDto(savedTanque.getId().toString(), savedTanque.getFuel_quantity(),
                savedTanque.getCap_max(), savedTanque.getCap_min());
    }
}
