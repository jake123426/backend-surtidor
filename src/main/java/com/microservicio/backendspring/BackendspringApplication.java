package com.microservicio.backendspring;

import com.microservicio.backendspring.model.Permisos;
import com.microservicio.backendspring.model.Roles;
import com.microservicio.backendspring.model.Usuario;
import com.microservicio.backendspring.repository.PermissionRepository;
import com.microservicio.backendspring.repository.RoleRepository;
import com.microservicio.backendspring.repository.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.*;

@SpringBootApplication
public class BackendspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendspringApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UsuarioRepository usuarioRepository, RoleRepository roleRepository, PermissionRepository permissionRepository) {
		return args -> {
			usuarioRepository.deleteAll();
			permissionRepository.deleteAll();
			roleRepository.deleteAll();

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
					.password("$2a$10$XXVAn4IhigiuOOiw6ehmn.44bmJdaB7rwlQK.KLdbEu2RVgxeo2GC").status(1).roles(List.of(adminRol)).build();
			usuarioRepository.save(admin);

			List<String> clientRoles = List.of("CLIENT");
			Roles clientRol = roleRepository.findByName(clientRoles.getFirst()).orElse(null);
			assert clientRol != null;
			Usuario client = Usuario.builder().name("rosa").email("rosa@correo.com")
					.password("$2a$10$XXVAn4IhigiuOOiw6ehmn.44bmJdaB7rwlQK.KLdbEu2RVgxeo2GC").status(1).roles(List.of(clientRol)).build();
			usuarioRepository.save(client);

			List<String> sellerRoles = List.of("SELLER");
			Roles sellerRol = roleRepository.findByName(sellerRoles.getFirst()).orElse(null);
			assert sellerRol != null;
			Usuario seller = Usuario.builder().name("carlos").email("carlos@correo.com")
					.password("$2a$10$XXVAn4IhigiuOOiw6ehmn.44bmJdaB7rwlQK.KLdbEu2RVgxeo2GC").status(1).roles(List.of(sellerRol)).build();
			usuarioRepository.save(seller);

//			Usuario user = usuarioRepository.findAll().getFirst();
//			System.out.println(user);

		};
	}
}
