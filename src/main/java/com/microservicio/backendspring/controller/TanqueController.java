package com.microservicio.backendspring.controller;


import com.microservicio.backendspring.dto.CreateTankDto;
import com.microservicio.backendspring.dto.ResponseTankDto;
import com.microservicio.backendspring.service.TanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TanqueController {

    @Autowired
    TanqueService tanqueService;

    @PostMapping("/tanque")
    public ResponseEntity<?> createTanque(@RequestBody CreateTankDto tankDto){
        try {
            ResponseTankDto responseTankDto = tanqueService.createTanque(tankDto);
            return new ResponseEntity<ResponseTankDto>(responseTankDto, HttpStatus.CREATED);
        } catch ( Exception e ) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tanque/all")
    public ResponseEntity<?> getAllVehiculo(){
        try {
            List<ResponseTankDto> responseTankDtos = tanqueService.findAll();
            return new ResponseEntity<>(responseTankDtos, HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
