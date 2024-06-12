package com.microservicio.backendspring.controllerGrapQL;

import com.microservicio.backendspring.dto.CreateTankDto;
import com.microservicio.backendspring.dto.ResponseTankDto;
import com.microservicio.backendspring.service.TanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class TankController {

    @Autowired
    private TanqueService tanqueService;

    @QueryMapping
    public List<ResponseTankDto> getAllTank() {
        return tanqueService.findAll();
    }

    @MutationMapping
    public ResponseTankDto saveTank(@Argument CreateTankDto tankDto) {
        return tanqueService.createTanque(tankDto);
    }

}
