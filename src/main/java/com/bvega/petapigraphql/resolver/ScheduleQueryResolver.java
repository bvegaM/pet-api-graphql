package com.bvega.petapigraphql.resolver;

import com.bvega.petapigraphql.entity.Schedule;
import com.bvega.petapigraphql.repository.ScheduleCrudRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleQueryResolver implements GraphQLQueryResolver {

    private final ScheduleCrudRepository scheduleCrudRepository;

    public ScheduleQueryResolver(ScheduleCrudRepository scheduleCrudRepository) {
        this.scheduleCrudRepository = scheduleCrudRepository;
    }

    public List<Schedule> findScheduleForEmployee(Long id){
        return scheduleCrudRepository.findByEmployeesId(id);
    }

    public List<Schedule> findScheduleForPet(Long id){
        return scheduleCrudRepository.findByPetsId(id);
    }

    public List<Schedule> findScheduleForCustomer(Long id){
        return scheduleCrudRepository.findByPetsOwnerId(id);
    }
}
