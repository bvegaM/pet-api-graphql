package com.bvega.petapigraphql.repository;

import com.bvega.petapigraphql.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetCrudRepository extends JpaRepository<Pet,Long> {

    List<Pet> findByOwnerId(Long id);
}
