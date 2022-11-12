package com.bvega.petapigraphql.resolver;

import com.bvega.petapigraphql.entity.Pet;
import com.bvega.petapigraphql.repository.PetCrudRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetQueryResolver implements GraphQLQueryResolver {

    private final PetCrudRepository petCrudRepository;

    public PetQueryResolver(PetCrudRepository petCrudRepository) {
        this.petCrudRepository = petCrudRepository;
    }

    public List<Pet> findPets(){
        return petCrudRepository.findAll();
    }

    public Pet findPet(Long id){
        return petCrudRepository.findById(id).orElse(null);
    }

    public List<Pet> findPetsByOwner(Long ownerId){
        return petCrudRepository.findByOwnerId(ownerId);
    }
}
