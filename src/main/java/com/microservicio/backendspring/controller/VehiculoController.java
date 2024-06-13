package com.microservicio.backendspring.controller;


import com.microservicio.backendspring.dto.CreateVehicleDto;
import com.microservicio.backendspring.dto.ResponseVehicleDto;
import com.microservicio.backendspring.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api")
public class VehiculoController {

//    @Autowired
//    VehiculoService vehiculoService;
//
//    @PostMapping("/vehiculo")
//    public ResponseEntity<?> createVehiculo(@RequestBody CreateVehicleDto vehiculoDto){
//        try {
//            ResponseVehicleDto responseVehicleDto = vehiculoService.createVehiculo(vehiculoDto);
//            return new ResponseEntity<ResponseVehicleDto>(responseVehicleDto, HttpStatus.CREATED);
//        } catch ( Exception e ) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/vehiculo/all")
//    public ResponseEntity<?> getAllVehiculo(){
//        try {
//            List<ResponseVehicleDto> responseVehicleDtoList = vehiculoService.findAll();
//            return new ResponseEntity<>(responseVehicleDtoList, HttpStatus.OK);
//        } catch ( Exception e ) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
