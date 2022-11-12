package com.bvega.petapigraphql.repository;

import com.bvega.petapigraphql.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerCrudRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByPetsId(Long id);
}
