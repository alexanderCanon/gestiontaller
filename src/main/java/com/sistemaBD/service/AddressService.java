package com.sistemaBD.service;

import com.sistemaBD.domain.Address;
import com.sistemaBD.domain.City;
import com.sistemaBD.domain.Country;
import com.sistemaBD.domain.Department;
import com.sistemaBD.dto.request.AddressRequest;
import com.sistemaBD.dto.response.AddressResponse;
import com.sistemaBD.repository.AddressRepository;
import com.sistemaBD.repository.CityRepository;
import com.sistemaBD.repository.CountryRepository;
import com.sistemaBD.repository.DepartmentRepository;
import com.sistemaBD.service.iservice.IAddressService;
import com.sistemaBD.service.mapper.AddressMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;
    private final DepartmentRepository departmentRepository;
    private final CityRepository cityRepository;
    private final AddressMapper addressMapper;

    @Override
    public List<AddressResponse> findAll() {
        return addressRepository.findAll().stream()
                .map(addressMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponse findById(Integer id) {
        return addressRepository.findById(id)
                .map(addressMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    @Override
    public AddressResponse save(AddressRequest request) {
        Country country = countryRepository.findById(request.getCountryId()).orElseThrow(() -> new RuntimeException("Country not found"));
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found"));
        City city = cityRepository.findById(request.getCityId()).orElseThrow(() -> new RuntimeException("City not found"));

        Address address = addressMapper.toEntity(request);
        address.setCountry(country);
        address.setDepartment(department);
        address.setCity(city);
        
        return addressMapper.toResponse(addressRepository.save(address));
    }

    @Override
    public AddressResponse update(Integer id, AddressRequest request) {
        Address addressToUpdate = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        Country country = countryRepository.findById(request.getCountryId()).orElseThrow(() -> new RuntimeException("Country not found"));
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found"));
        City city = cityRepository.findById(request.getCityId()).orElseThrow(() -> new RuntimeException("City not found"));

        addressMapper.updateFromDto(request, addressToUpdate);
        addressToUpdate.setCountry(country);
        addressToUpdate.setDepartment(department);
        addressToUpdate.setCity(city);

        return addressMapper.toResponse(addressRepository.save(addressToUpdate));
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }
}
