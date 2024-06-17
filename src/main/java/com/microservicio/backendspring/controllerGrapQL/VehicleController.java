package com.microservicio.backendspring.controllerGrapQL;


import com.microservicio.backendspring.dto.CreateVehicleDto;
import com.microservicio.backendspring.dto.ResponseVehicleDto;
import com.microservicio.backendspring.model.Vehiculo;
import com.microservicio.backendspring.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//@Controller
public class VehicleController {

//    @Autowired
//    private VehiculoService vehiculoService;
//
//    @QueryMapping
//    public List<ResponseVehicleDto> getAllVehicle() {
//        return vehiculoService.findAll();
//    }
//
//    @MutationMapping
//    public ResponseVehicleDto saveVehicle(@Argument CreateVehicleDto vehicleDto) {
//        return  vehiculoService.createVehiculo(vehicleDto);
//    }

}
