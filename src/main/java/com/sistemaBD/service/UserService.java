package com.sistemaBD.service;

import com.sistemaBD.domain.Address;
import com.sistemaBD.domain.Role;
import com.sistemaBD.domain.User;
import com.sistemaBD.dto.request.UserRequest;
import com.sistemaBD.dto.response.UserResponse;
import com.sistemaBD.repository.AddressRepository;
import com.sistemaBD.repository.RoleRepository;
import com.sistemaBD.repository.UserRepository;
import com.sistemaBD.service.iservice.IUserService;
import com.sistemaBD.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(String dpi) {
        return userRepository.findById(dpi)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserResponse save(UserRequest request) {
        Address address = addressRepository.findById(request.getAddressId()).orElseThrow(() -> new RuntimeException("Address not found"));
        Role role = roleRepository.findById(request.getRoleId()).orElseThrow(() -> new RuntimeException("Role not found"));

        User user = userMapper.toEntity(request);
        user.setAddress(address);
        user.setRole(role);

        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public UserResponse update(String dpi, UserRequest request) {
        User userToUpdate = userRepository.findById(dpi)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address address = addressRepository.findById(request.getAddressId()).orElseThrow(() -> new RuntimeException("Address not found"));
        Role role = roleRepository.findById(request.getRoleId()).orElseThrow(() -> new RuntimeException("Role not found"));

        userMapper.updateFromDto(request, userToUpdate);
        userToUpdate.setAddress(address);
        userToUpdate.setRole(role);

        return userMapper.toResponse(userRepository.save(userToUpdate));
    }

    @Override
    public void delete(String dpi) {
        userRepository.deleteById(dpi);
    }
}
