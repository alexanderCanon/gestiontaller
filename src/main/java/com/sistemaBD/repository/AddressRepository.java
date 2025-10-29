package com.sistemaBD.repository;

import com.sistemaBD.domain.Address;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AddressRepository extends JpaRepository<Address, Integer> {

}
