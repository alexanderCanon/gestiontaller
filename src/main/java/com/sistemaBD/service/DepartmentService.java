package com.sistemaBD.service;

import com.sistemaBD.domain.Department;
import com.sistemaBD.dto.request.DepartmentRequest;
import com.sistemaBD.dto.response.DepartmentResponse;
import com.sistemaBD.repository.DepartmentRepository;
import com.sistemaBD.service.iservice.IDepartmentService;
import com.sistemaBD.service.mapper.DepartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentResponse> findAll() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse findById(Integer id) {
        return departmentRepository.findById(id)
                .map(departmentMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public DepartmentResponse save(DepartmentRequest request) {
        Department department = departmentMapper.toEntity(request);
        return departmentMapper.toResponse(departmentRepository.save(department));
    }

    @Override
    public DepartmentResponse update(Integer id, DepartmentRequest request) {
        Department departmentToUpdate = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        departmentMapper.updateFromDto(request, departmentToUpdate);
        return departmentMapper.toResponse(departmentRepository.save(departmentToUpdate));
    }

    @Override
    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }
}
