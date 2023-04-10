package com.stl.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stl.auth.entity.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
