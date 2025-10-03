package com.sistemaBD.controller;

import com.sistemaBD.dto.OilRequestDTO;
import com.sistemaBD.dto.OilResponseDTO;
import com.sistemaBD.service.OilService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/oils") // Define la URL base para los endpoints de aceites
public class OilController {

    private final OilService oilService;

    // Inyección de dependencias a través del constructor
    public OilController(OilService oilService) {
        this.oilService = oilService;
    }

    /**
     * Endpoint para OBTENER todos los aceites.
     * HTTP GET /api/v1/oils
     */
    @GetMapping
    public ResponseEntity<List<OilResponseDTO>> getAllOils() {
        List<OilResponseDTO> oils = oilService.findAll();
        return new ResponseEntity<>(oils, HttpStatus.OK);
    }

    /**
     * Endpoint para OBTENER un aceite por su ID.
     * HTTP GET /api/v1/oils/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<OilResponseDTO> getOilById(@PathVariable Integer id) {
        OilResponseDTO oil = oilService.findById(id);
        return new ResponseEntity<>(oil, HttpStatus.OK);
    }

    /**
     * Endpoint para CREAR un nuevo aceite.
     * HTTP POST /api/v1/oils
     */
    @PostMapping
    public ResponseEntity<OilResponseDTO> createOil(@Valid @RequestBody OilRequestDTO requestDTO) {
        OilResponseDTO newOil = oilService.save(requestDTO);
        return new ResponseEntity<>(newOil, HttpStatus.CREATED);
    }

    /**
     * Endpoint para ACTUALIZAR un aceite existente.
     * HTTP PUT /api/v1/oils/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<OilResponseDTO> updateOil(@PathVariable Integer id, @Valid @RequestBody OilRequestDTO requestDTO) {
        OilResponseDTO updatedOil = oilService.update(id, requestDTO);
        return new ResponseEntity<>(updatedOil, HttpStatus.OK);
    }

    /**
     * Endpoint para ELIMINAR un aceite.
     * HTTP DELETE /api/v1/oils/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOil(@PathVariable Integer id) {
        oilService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}