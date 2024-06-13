package com.microservicio.backendspring;

import com.microservicio.backendspring.model.*;
import com.microservicio.backendspring.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

@SpringBootApplication
public class BackendspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendspringApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UsuarioRepository usuarioRepository, RoleRepository roleRepository,
										PermissionRepository permissionRepository, FuelRepository fuelRepository,
										TankRepository tankRepository, PumpRepository pumpRepository /*VehiculoRepository vehiculoRepository*/) {
		return args -> {
			usuarioRepository.deleteAll();
			permissionRepository.deleteAll();
			roleRepository.deleteAll();
//			vehiculoRepository.deleteAll();
			fuelRepository.deleteAll();
			tankRepository.deleteAll();
			pumpRepository.deleteAll();

// *		Agregar Permisos
			List<Permisos> permisos = Arrays.asList(
				Permisos.builder().name("READ").build(),
				Permisos.builder().name("CREATE").build(),
				Permisos.builder().name("UPDATE").build(),
				Permisos.builder().name("DELETE").build()
			);
			permissionRepository.saveAll( permisos );

// *		Agregar Roles
//			ADMIN
			List<String> adminPermisos = Arrays.asList("CREATE", "UPDATE", "DELETE", "READ");
//			List<ObjectId> permisosId = permissionRepository.findAllByNameIn(adminPermisos).stream().map(Permisos::getId).toList();
			List<Permisos> permisosDocument = permissionRepository.findAllByNameIn(adminPermisos);
			Roles rolesAdmin = Roles.builder().name("ADMIN").permisos(permisosDocument).build();
			roleRepository.save(rolesAdmin);
//			List<Roles> rolesDocument = roleRepository.findAll();
//			System.out.println(rolesDocument);

//			CLIENT
			List<String> clientPermisos = List.of("READ");
			List<Permisos> clientDocument = permissionRepository.findAllByNameIn(clientPermisos);
			Roles rolesClient = Roles.builder().name("CLIENT").permisos(clientDocument).build();
			roleRepository.save(rolesClient);

//			SELLER
			List<String> sellerPermisos = Arrays.asList("CREATE", "READ");
			List<Permisos> sellerDocument = permissionRepository.findAllByNameIn(sellerPermisos);
			Roles rolesSeller = Roles.builder().name("SELLER").permisos(sellerDocument).build();
			roleRepository.save(rolesSeller);

//*		    Agregar Usuarios
			List<String> adminRoles = List.of("ADMIN");
			Roles adminRol = roleRepository.findByName(adminRoles.getFirst()).orElse(null);
            assert adminRol != null;
            Usuario admin = Usuario.builder().name("jaime").email("jaime@correo.com")
					.password("$2a$10$XXVAn4IhigiuOOiw6ehmn.44bmJdaB7rwlQK.KLdbEu2RVgxeo2GC").status(1).bomba(null).roles(List.of(adminRol)).build();
			usuarioRepository.save(admin);

			List<String> clientRoles = List.of("CLIENT");
			Roles clientRol = roleRepository.findByName(clientRoles.getFirst()).orElse(null);
			assert clientRol != null;
			Usuario client = Usuario.builder().name("rosa").email("rosa@correo.com")
					.password("$2a$10$XXVAn4IhigiuOOiw6ehmn.44bmJdaB7rwlQK.KLdbEu2RVgxeo2GC").status(1).bomba(null).roles(List.of(clientRol)).build();
			usuarioRepository.save(client);

			List<String> sellerRoles = List.of("SELLER");
			Roles sellerRol = roleRepository.findByName(sellerRoles.getFirst()).orElse(null);
			assert sellerRol != null;
			Usuario seller = Usuario.builder().name("carlos").email("carlos@correo.com")
					.password("$2a$10$XXVAn4IhigiuOOiw6ehmn.44bmJdaB7rwlQK.KLdbEu2RVgxeo2GC").status(1).bomba(null).roles(List.of(sellerRol)).build();
			usuarioRepository.save(seller);

//			Usuario user = usuarioRepository.findAll().getFirst();
//			System.out.println(user);

//*			Agregar Vehiculos
//			Vehiculo toyota = Vehiculo.builder().brand("Toyota").model("Vitara").fuel_type("Gasolina")
//					.number_plate("4578-ADC").path_image("image/path").status(1).build();
//			vehiculoRepository.save(toyota);
//
//			Vehiculo suzuki = Vehiculo.builder().brand("Suzuki").model("Jimmy").fuel_type("Diesel")
//					.number_plate("7895-JKA").path_image("image/path").status(1).build();
//			vehiculoRepository.save(suzuki);

//*			Agregar Combustibles
			Combustible gasolina = Combustible.builder().name("Gasolina").sale_price(8.45).purchase_price(5.99)
					.measurement(40).build();
			fuelRepository.save(gasolina);

			Combustible diesel = Combustible.builder().name("Diesel").sale_price(9.15).purchase_price(8.99)
					.measurement(60).build();
			fuelRepository.save(diesel);

			Combustible gasGlp = Combustible.builder().name("Gas GLP").sale_price(6.5).purchase_price(4.99)
					.measurement(100).build();
			fuelRepository.save(gasGlp);

//*			Agregar Tanques
			Tanque tanque01 = Tanque.builder().name("Tanque01").fuel_quantity(100).cap_max(210).cap_min(10).status(1).fuel(gasolina).build();
			tankRepository.save(tanque01);

			Tanque tanque02 = Tanque.builder().name("Tanque02").fuel_quantity(150).cap_max(250).cap_min(5).status(1).fuel(diesel).build();
			tankRepository.save(tanque02);

			Tanque tanque03 = Tanque.builder().name("Tanque03").fuel_quantity(200).cap_max(300).cap_min(15).status(1).fuel(gasGlp).build();
			tankRepository.save(tanque03);

//*			Agregar Bombas
			Bomba bomba01 = Bomba.builder().name("Bomba01").description("45-FD").fuel_type("Gasolina").status(1).tanque(tanque01).build();
			pumpRepository.save(bomba01);

			Bomba bomba02 = Bomba.builder().name("Bomba02").description("82-QS").fuel_type("Diesel").status(1).tanque(tanque02).build();
			pumpRepository.save(bomba02);
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
//						.allowedOrigins("http://localhost:8080", "http://127.0.0.1:8080")
						.allowedOrigins("*")
						.allowedMethods("GET", "POST", "OPTIONS")
						.allowedHeaders("*");
//						.maxAge(3600)
//						.allowCredentials(true)
//						.exposedHeaders("*");


			}
		};
	}
}
