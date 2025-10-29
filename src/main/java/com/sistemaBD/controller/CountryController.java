package com.sistemaBD.controller;

import com.sistemaBD.dto.request.CountryRequest;
import com.sistemaBD.dto.response.CountryResponse;
import com.sistemaBD.service.iservice.ICountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@AllArgsConstructor
public class CountryController {

    private final ICountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryResponse>> getAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(countryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CountryResponse> save(@RequestBody CountryRequest request) {
        return new ResponseEntity<>(countryService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> update(@PathVariable Integer id, @RequestBody CountryRequest request) {
        return ResponseEntity.ok(countryService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        countryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
