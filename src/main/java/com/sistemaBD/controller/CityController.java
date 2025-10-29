package com.sistemaBD.controller;

import com.sistemaBD.dto.request.CityRequest;
import com.sistemaBD.dto.response.CityResponse;
import com.sistemaBD.service.iservice.ICityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@AllArgsConstructor
public class CityController {

    private final ICityService cityService;

    @GetMapping
    public ResponseEntity<List<CityResponse>> getAll() {
        return ResponseEntity.ok(cityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(cityService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CityResponse> save(@RequestBody CityRequest request) {
        return new ResponseEntity<>(cityService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityResponse> update(@PathVariable Integer id, @RequestBody CityRequest request) {
        return ResponseEntity.ok(cityService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        cityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
