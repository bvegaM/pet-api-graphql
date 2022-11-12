package com.bvega.petapigraphql.mutator;

import com.bvega.petapigraphql.dto.CustomerDto;
import com.bvega.petapigraphql.entity.Customer;
import com.bvega.petapigraphql.repository.CustomerCrudRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class CustomerMutationResolver implements GraphQLMutationResolver {

    private final CustomerCrudRepository customerCrudRepository;

    public CustomerMutationResolver(CustomerCrudRepository customerCrudRepository) {
        this.customerCrudRepository = customerCrudRepository;
    }

    public Customer saveCustomer(CustomerDto customerDto){
        return customerCrudRepository.save(Customer.builder().name(customerDto.getName())
                .phoneNumber(customerDto.getPhoneNumber())
                .notes(customerDto.getNotes()).build());
    }
}
