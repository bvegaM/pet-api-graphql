package com.bvega.petapigraphql.resolver;

import com.bvega.petapigraphql.entity.Customer;
import com.bvega.petapigraphql.repository.CustomerCrudRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerQueryResolver implements GraphQLQueryResolver {

    private final CustomerCrudRepository customerCrudRepository;

    public CustomerQueryResolver(CustomerCrudRepository customerCrudRepository){
        this.customerCrudRepository = customerCrudRepository;
    }

    public List<Customer> findCustomers(){
        return customerCrudRepository.findAll();
    }

    public Customer findOwnerByPet(Long petId){
        return customerCrudRepository.findByPetsId(petId).orElse(null);
    }
}
