package com.microservicio.backendspring.service;


import com.microservicio.backendspring.dto.CreateFuelDto;
import com.microservicio.backendspring.dto.ResponseFuelDto;
import com.microservicio.backendspring.model.Combustible;
import com.microservicio.backendspring.repository.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CombustibleService {

    @Autowired
    private FuelRepository fuelRepository;

    public List<ResponseFuelDto> findAll() {
        List<Combustible> combustibles = fuelRepository.findAll();
        List<ResponseFuelDto> fuelDtos = new ArrayList<>();
        combustibles.forEach(fuel -> {
            ResponseFuelDto responseFuelDto = new ResponseFuelDto(fuel.getId().toString(), fuel.getName(),
                    fuel.getSale_price(), fuel.getPurchase_price(), fuel.getMeasurement());
            fuelDtos.add(responseFuelDto);
        });
        return fuelDtos;
    }
    public ResponseFuelDto createCombustible(CreateFuelDto fuelDto) {
        Combustible combustible = Combustible.builder().name(fuelDto.name()).sale_price(fuelDto.sale_price())
                .purchase_price(fuelDto.purchase_price()).measurement(fuelDto.measurement()).build();
        Combustible combustibleSave = fuelRepository.save(combustible);
        return new ResponseFuelDto(combustibleSave.getId().toString(), combustibleSave.getName(),
                combustibleSave.getSale_price(), combustibleSave.getPurchase_price(), combustibleSave.getMeasurement());
    }

}
