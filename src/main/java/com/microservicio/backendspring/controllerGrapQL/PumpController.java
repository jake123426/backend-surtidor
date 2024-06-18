package com.microservicio.backendspring.controllerGrapQL;


import com.microservicio.backendspring.dto.CreatePumpDto;
import com.microservicio.backendspring.dto.ResponsePumpDto;
import com.microservicio.backendspring.service.BombaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class PumpController {

    @Autowired
    private BombaService bombaService;

    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    @QueryMapping
    public List<ResponsePumpDto> getAllPump(){
        return bombaService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public ResponsePumpDto savePump(@Argument CreatePumpDto pumpDto){
        return bombaService.createBomba(pumpDto);
    }

}
