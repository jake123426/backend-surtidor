package com.microservicio.backendspring.service;


import com.microservicio.backendspring.dto.CreateTankDto;
import com.microservicio.backendspring.dto.ResponseTankDto;
import com.microservicio.backendspring.model.Combustible;
import com.microservicio.backendspring.model.Tanque;
import com.microservicio.backendspring.repository.FuelRepository;
import com.microservicio.backendspring.repository.TankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TanqueService {

    @Autowired
    private TankRepository tankRepository;

    @Autowired
    private FuelRepository fuelRepository;

    public List<ResponseTankDto> findAll() {
        List<Tanque> tanques = tankRepository.findAll();
        List<ResponseTankDto> tankDtos = new ArrayList<>();
        tanques.forEach(tanque -> {
            ResponseTankDto responseTankDto = new ResponseTankDto(tanque.getId().toString(), tanque.getName(), tanque.getFuel_quantity(),
                    tanque.getCap_max(), tanque.getCap_min(), tanque.getFuel() != null ? tanque.getFuel().getName() : null);
            tankDtos.add(responseTankDto);
        });
        return tankDtos;
    }
    public ResponseTankDto createTanque(CreateTankDto tankDto) {
        Combustible combustible = fuelRepository.findCombustibleByName(tankDto.fuel()).orElse(null);
        Tanque tanque = Tanque.builder().name(tankDto.name()).fuel_quantity(tankDto.fuel_quantity()).cap_max(tankDto.cap_max())
                .cap_min(tankDto.cap_min()).status(1).fuel(combustible).build();
        Tanque savedTanque = tankRepository.save(tanque);
        return new ResponseTankDto(savedTanque.getId().toString(), tanque.getName(), savedTanque.getFuel_quantity(),
                savedTanque.getCap_max(), savedTanque.getCap_min(), savedTanque.getFuel() != null ? savedTanque.getFuel().getName() : null);
    }
}
