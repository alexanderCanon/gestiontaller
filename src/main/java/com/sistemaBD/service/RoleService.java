package com.sistemaBD.service;

import com.sistemaBD.domain.Role;
import com.sistemaBD.dto.request.RoleRequest;
import com.sistemaBD.dto.response.RoleResponse;
import com.sistemaBD.repository.RoleRepository;
import com.sistemaBD.service.iservice.IRoleService;
import com.sistemaBD.service.mapper.RoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleResponse> findAll() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponse findById(Integer id) {
        return roleRepository.findById(id)
                .map(roleMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    @Override
    public RoleResponse save(RoleRequest request) {
        Role role = roleMapper.toEntity(request);
        return roleMapper.toResponse(roleRepository.save(role));
    }

    @Override
    public RoleResponse update(Integer id, RoleRequest request) {
        Role roleToUpdate = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        
        roleMapper.updateFromDto(request, roleToUpdate);
        
        return roleMapper.toResponse(roleRepository.save(roleToUpdate));
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }
}
