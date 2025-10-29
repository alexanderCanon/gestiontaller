package com.sistemaBD.controller;

import com.sistemaBD.dto.request.VehicleRequest;
import com.sistemaBD.dto.response.VehicleResponse;
import com.sistemaBD.service.iservice.IVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@AllArgsConstructor
public class VehicleController {

    private final IVehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getAll() {
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @GetMapping("/{plate}")
    public ResponseEntity<VehicleResponse> getById(@PathVariable String plate) {
        return ResponseEntity.ok(vehicleService.findById(plate));
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> save(@RequestBody VehicleRequest request) {
        return new ResponseEntity<>(vehicleService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{plate}")
    public ResponseEntity<VehicleResponse> update(@PathVariable String plate, @RequestBody VehicleRequest request) {
        return ResponseEntity.ok(vehicleService.update(plate, request));
    }

    @DeleteMapping("/{plate}")
    public ResponseEntity<Void> delete(@PathVariable String plate) {
        vehicleService.delete(plate);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
