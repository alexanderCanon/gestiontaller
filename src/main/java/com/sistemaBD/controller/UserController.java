package com.sistemaBD.controller;

import com.sistemaBD.dto.request.UserRequest;
import com.sistemaBD.dto.response.UserResponse;
import com.sistemaBD.service.iservice.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{dpi}")
    public ResponseEntity<UserResponse> getById(@PathVariable String dpi) {
        return ResponseEntity.ok(userService.findById(dpi));
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{dpi}")
    public ResponseEntity<UserResponse> update(@PathVariable String dpi, @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.update(dpi, request));
    }

    @DeleteMapping("/{dpi}")
    public ResponseEntity<Void> delete(@PathVariable String dpi) {
        userService.delete(dpi);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
