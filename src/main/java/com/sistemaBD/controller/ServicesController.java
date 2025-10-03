package com.sistemaBD.controller;


import com.sistemaBD.dto.ServicesRequestDTO;
import com.sistemaBD.dto.ServicesResponseDTO;
import com.sistemaBD.service.IServicesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicesController {

    @Autowired
    private IServicesService iServicesService;

    // Endpoint para OBTENER TODOS los servicios
    // GET http://localhost:8080/api/v1/servicios
    @GetMapping
    public ResponseEntity<List<ServicesResponseDTO>> getAll() {
        return ResponseEntity.ok(iServicesService.getAllServices());
    }

    // Endpoint para OBTENER UN servicio por ID
    // GET http://localhost:8080/api/v1/servicios/1
    @GetMapping("/{id}")
    public ResponseEntity<ServicesResponseDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(iServicesService.getServiceById(id));
    }

    /**
     * Endpoint to create a new service
     * @param requestDTO
     * @return
     * @RequestBody converts service's JSON to an object
     */
    @PostMapping
    public ResponseEntity<ServicesResponseDTO> create(@Valid @RequestBody ServicesRequestDTO requestDTO) {
        ServicesResponseDTO createdService = iServicesService.createService(requestDTO);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    // Endpoint para ACTUALIZAR un servicio
    // PUT http://localhost:8080/api/v1/servicios/1
    @PutMapping("/{id}")
    public ResponseEntity<ServicesResponseDTO> update(@PathVariable Integer id,@Valid @RequestBody ServicesRequestDTO requestDTO) {
        return ResponseEntity.ok(iServicesService.updateService(id, requestDTO));
    }

    // Endpoint para ELIMINAR un servicio
    // DELETE http://localhost:8080/api/v1/servicios/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        iServicesService.deleteService(id);
        return ResponseEntity.noContent().build(); // Retorna un código 204 No Content
    }

    // Endpoint para OBTENER servicios por tipo
    // GET http://localhost:8080/api/v1/servicios/tipo/Servicio Mayor
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ServicesResponseDTO>> getByType(@PathVariable String tipo) {
        return ResponseEntity.ok(iServicesService.getServicesByType(tipo));
    }


}
