package com.sistemaBD.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaBD.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
    // --- Búsqueda por Identificadores Únicos ---
    
    // findByDpi(String dpi) ya viene incluido por defecto si heredas 
    // de JpaRepository y usas el PK (sería findById)

    Optional<User> findByEmailIgnoreCase(String email);

    Optional<User> findByTelNumber(String telNumber);

    // --- Búsqueda por Atributos Comunes ---
    
    List<User> findByLastnameContainingIgnoreCase(String partialLastname);
    
    List<User> findByFirstnameContainingIgnoreCase(String partialFirstname);

    List<User> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(String partialFirstname, String partialLastname);

    // --- Búsqueda por Relaciones (FK) ---
    
    List<User> findByRoleId(int roleId);
    
    List<User> findByAddressId(int addressId);
    
    // --- Búsqueda Paginada ---
    
    // findAll(Pageable pageable) también viene incluido en JpaRepository
}
