package com.sistemaBD.service;

import com.sistemaBD.domain.ServiceEntity;
import com.sistemaBD.dto.request.ServiceRequest;
import com.sistemaBD.dto.response.ServiceResponse;
import com.sistemaBD.repository.ServiceEntityRepository;
import com.sistemaBD.service.iservice.IServiceEntityService;
import com.sistemaBD.service.mapper.ServiceEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceEntityService implements IServiceEntityService {

    private final ServiceEntityRepository serviceRepository;
    private final ServiceEntityMapper serviceEntityMapper;

    @Override
    public List<ServiceResponse> findAll() {
        return serviceRepository.findAll().stream()
                .map(serviceEntityMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceResponse findById(Integer id) {
        return serviceRepository.findById(id)
                .map(serviceEntityMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }

    @Override
    public ServiceResponse save(ServiceRequest request) {
        ServiceEntity serviceEntity = serviceEntityMapper.toEntity(request);
        return serviceEntityMapper.toResponse(serviceRepository.save(serviceEntity));
    }

    @Override
    public ServiceResponse update(Integer id, ServiceRequest request) {
        ServiceEntity serviceToUpdate = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        serviceEntityMapper.updateFromDto(request, serviceToUpdate);
        return serviceEntityMapper.toResponse(serviceRepository.save(serviceToUpdate));
    }

    @Override
    public void delete(Integer id) {
        serviceRepository.deleteById(id);
    }
}
