package com.microservicio.backendspring.controllerGrapQL;


import com.microservicio.backendspring.dto.CreateFuelDto;
import com.microservicio.backendspring.dto.ResponseFuelDto;
import com.microservicio.backendspring.model.Combustible;
import com.microservicio.backendspring.service.CombustibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FuelController {

    @Autowired
    private CombustibleService combustibleService;

//    @Secured("ROLE_USER")
//    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    @QueryMapping
    public List<ResponseFuelDto> getAllFuel() {
        return combustibleService.findAll();
    }
//    @PreAuthorize("hasAnyAuthority('CREATE', 'DELETE')")
//    @PreAuthorize("hasRole('ADMIN') or (hasAuthority('PERMISSION_VIEW_USERS') and hasAuthority('PERMISSION_MANAGE_USERS'))")
//    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN') or hasAnyAuthority('PERMISSION_VIEW_USERS', 'PERMISSION_MANAGE_USERS')")
    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public ResponseFuelDto saveFuel(@Argument CreateFuelDto fuelDto) {
        return combustibleService.createCombustible(fuelDto);
    }


}
