package com.sistemaBD.service;

import com.sistemaBD.domain.Services;
import com.sistemaBD.dto.ServicesRequestDTO;
import com.sistemaBD.dto.ServicesResponseDTO;
import com.sistemaBD.repository.ServicesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService implements IServicesService{

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private ServiceMapper serviceMapper; // Inyectamos el mapper

    @Override
    public List<ServicesResponseDTO> getAllServices() {
        List<Services> services = servicesRepository.findAll();
        return serviceMapper.toResponseDTOList(services);
    }

    @Override
    public ServicesResponseDTO getServiceById(Integer id) {
        Services service = findServiceByIdOrThrow(id);
        return serviceMapper.toResponseDTO(service);
    }

    @Override
    public ServicesResponseDTO createService(ServicesRequestDTO requestDTO) {
        Services newService = serviceMapper.toEntity(requestDTO);
        Services savedService = servicesRepository.save(newService);
        return serviceMapper.toResponseDTO(savedService);
    }

    @Override
    public ServicesResponseDTO updateService(Integer id, ServicesRequestDTO requestDTO) {
        Services existingService = findServiceByIdOrThrow(id);

        // Usamos el mapper para actualizar la entidad existente
        serviceMapper.updateEntityFromDto(requestDTO, existingService);

        Services updatedService = servicesRepository.save(existingService);
        return serviceMapper.toResponseDTO(updatedService);
    }

    @Override
    public void deleteService(Integer id) {
        if (!servicesRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar. Servicio no encontrado con el ID: " + id);
        }
        servicesRepository.deleteById(id);
    }

    @Override
    public List<ServicesResponseDTO> getServicesByType(String tipo) {
        List<Services> services = servicesRepository.findByTipo(tipo);
        return serviceMapper.toResponseDTOList(services);
    }

    // --- METODO PRIVADO PARA REUTILIZAR LA BÚSQUEDA ---
    private Services findServiceByIdOrThrow(Integer id) {
        return servicesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Servicio no encontrado con el ID: " + id));
    }
}
