package com.microservicio.backendspring.service;


import com.microservicio.backendspring.dto.CreateVehicleDto;
import com.microservicio.backendspring.dto.ResponseVehicleDto;
import com.microservicio.backendspring.model.Vehiculo;
import com.microservicio.backendspring.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<ResponseVehicleDto> findAll() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        List<ResponseVehicleDto> responseVehicleDtos = new ArrayList<>();
        vehiculos.forEach(vehiculo -> {
            ResponseVehicleDto responseVehicleDto = new ResponseVehicleDto(vehiculo.getId().toString(), vehiculo.getBrand(),
                    vehiculo.getModel(), vehiculo.getFuel_type(), vehiculo.getNumber_plate(), vehiculo.getPath_image());
            responseVehicleDtos.add(responseVehicleDto);
        });
        return responseVehicleDtos;
    }
    public ResponseVehicleDto createVehiculo(CreateVehicleDto vehicleDto) {
        Vehiculo vehiculo = Vehiculo.builder()
                .brand(vehicleDto.brand()).model(vehicleDto.model()).fuel_type(vehicleDto.fuel_type())
                .number_plate(vehicleDto.number_plate()).path_image(vehicleDto.path_image()).status(1).build();
        Vehiculo saveVehicle = vehiculoRepository.save(vehiculo);
        return new ResponseVehicleDto(saveVehicle.getId().toString(), saveVehicle.getBrand(),
                saveVehicle.getModel(), saveVehicle.getFuel_type(), saveVehicle.getNumber_plate(), saveVehicle.getPath_image());
    }
}
