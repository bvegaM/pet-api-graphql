package com.bvega.petapigraphql.mutator;

import com.bvega.petapigraphql.dto.PetDto;
import com.bvega.petapigraphql.entity.Customer;
import com.bvega.petapigraphql.entity.Pet;
import com.bvega.petapigraphql.repository.CustomerCrudRepository;
import com.bvega.petapigraphql.repository.PetCrudRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class PetMutationResolver implements GraphQLMutationResolver {

    private final PetCrudRepository petCrudRepository;

    private final CustomerCrudRepository customerCrudRepository;

    public PetMutationResolver(PetCrudRepository petCrudRepository, CustomerCrudRepository customerCrudRepository) {
        this.petCrudRepository = petCrudRepository;
        this.customerCrudRepository = customerCrudRepository;
    }

    public Pet savePet(PetDto petDto){
        Optional<Customer> customer = customerCrudRepository.findById(petDto.getOwnerId());
        return customer.map(value -> petCrudRepository.save(Pet.builder().name(petDto.getName())
                .type(petDto.getType())
                .birthDate(LocalDate.parse(petDto.getBirthDate()))
                .owner(value)
                .build())).orElseThrow(() -> new Error("user not find"));
    }
}
