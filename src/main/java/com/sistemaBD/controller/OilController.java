package com.sistemaBD.controller;

import com.sistemaBD.dto.request.OilRequest;
import com.sistemaBD.dto.response.OilResponse;
import com.sistemaBD.service.iservice.IOilService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/oils")
@AllArgsConstructor
public class OilController {

    private final IOilService oilService;

    @GetMapping
    public ResponseEntity<List<OilResponse>> getAll() {
        return ResponseEntity.ok(oilService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OilResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(oilService.findById(id));
    }

    @PostMapping
    public ResponseEntity<OilResponse> save(@RequestBody OilRequest request) {
        return new ResponseEntity<>(oilService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OilResponse> update(@PathVariable Integer id, @RequestBody OilRequest request) {
        return ResponseEntity.ok(oilService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        oilService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
