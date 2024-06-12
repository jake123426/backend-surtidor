package com.microservicio.backendspring.controller;

import com.microservicio.backendspring.dto.CreateFuelDto;
import com.microservicio.backendspring.dto.ResponseFuelDto;
import com.microservicio.backendspring.service.CombustibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CombustibleController {

    @Autowired
    CombustibleService combustibleService;

    @PostMapping("/combustible")
    public ResponseEntity<?> createCombustible(@RequestBody CreateFuelDto createFuelDto){
        try {
            ResponseFuelDto responseFuelDto = combustibleService.createCombustible(createFuelDto);
            return new ResponseEntity<ResponseFuelDto>(responseFuelDto, HttpStatus.CREATED);
        } catch ( Exception e ) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/combustible/all")
    public ResponseEntity<?> getAllCombustible(){
        try {
            List<ResponseFuelDto> responseFuelDtos = combustibleService.findAll();
            return new ResponseEntity<>(responseFuelDtos, HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
