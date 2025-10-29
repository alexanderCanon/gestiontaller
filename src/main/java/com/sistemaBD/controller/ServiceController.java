package com.sistemaBD.controller;

import com.sistemaBD.dto.request.ServiceRequest;
import com.sistemaBD.dto.response.ServiceResponse;
import com.sistemaBD.service.iservice.IServiceEntityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
@AllArgsConstructor
public class ServiceController {

    private final IServiceEntityService serviceEntityService;

    @GetMapping
    public ResponseEntity<List<ServiceResponse>> getAll() {
        return ResponseEntity.ok(serviceEntityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(serviceEntityService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceResponse> save(@RequestBody ServiceRequest request) {
        return new ResponseEntity<>(serviceEntityService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable Integer id, @RequestBody ServiceRequest request) {
        return ResponseEntity.ok(serviceEntityService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        serviceEntityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
