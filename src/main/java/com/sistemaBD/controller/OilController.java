package com.sistemaBD.controller;

import com.sistemaBD.dto.OilRequestDTO;
import com.sistemaBD.dto.OilResponseDTO;
import com.sistemaBD.service.OilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aceites")
public class OilController {

    @Autowired
    private OilService oilService;

    @GetMapping
    public ResponseEntity<List<OilResponseDTO>> getAll() {
        return ResponseEntity.ok(oilService.getAllOils());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OilResponseDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(oilService.getOilById(id));
    }

    @PostMapping
    public ResponseEntity<OilResponseDTO> create(@Valid @RequestBody OilRequestDTO requestDTO) {
        OilResponseDTO newOil = oilService.createOil(requestDTO);
        return new ResponseEntity<>(newOil, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OilResponseDTO> update(@PathVariable Integer id, @Valid @RequestBody OilRequestDTO requestDTO) {
        OilResponseDTO updatedOil = oilService.updateOil(id, requestDTO);
        return ResponseEntity.ok(updatedOil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        oilService.deleteOil(id);
        return ResponseEntity.noContent().build();
    }
}
