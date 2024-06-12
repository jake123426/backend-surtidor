package com.microservicio.backendspring.controllerGrapQL;


import com.microservicio.backendspring.dto.CreateFuelDto;
import com.microservicio.backendspring.dto.ResponseFuelDto;
import com.microservicio.backendspring.model.Combustible;
import com.microservicio.backendspring.service.CombustibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FuelController {

    @Autowired
    private CombustibleService combustibleService;

    @QueryMapping
    public List<ResponseFuelDto> getAllFuel() {
        return combustibleService.findAll();
    }

    @MutationMapping
    public ResponseFuelDto saveFuel(@Argument CreateFuelDto fuelDto) {
        return combustibleService.createCombustible(fuelDto);
    }


}
