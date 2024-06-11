package com.microservicio.backendspring.controller;


import com.microservicio.backendspring.dto.CreatePumpDto;
import com.microservicio.backendspring.dto.ResponsePumpDto;
import com.microservicio.backendspring.service.BombaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BombaController {

    @Autowired
    private BombaService bombaService;

    @PostMapping("/bomba")
    public ResponseEntity<?> createBomba(@RequestBody CreatePumpDto pumpDto) {
        try {
            ResponsePumpDto responsePumpDto = bombaService.createBomba(pumpDto);
            return new ResponseEntity<>(responsePumpDto, HttpStatus.CREATED);
        } catch ( Exception e ) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/bomba/all")
    public ResponseEntity<?> getAllBomba(){
        try {
            List<ResponsePumpDto> responsePumpDtos = bombaService.findAll();
            return new ResponseEntity<>(responsePumpDtos, HttpStatus.OK);
        } catch ( Exception e ) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
