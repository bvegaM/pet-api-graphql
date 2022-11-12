package com.bvega.petapigraphql.mutator;

import com.bvega.petapigraphql.dto.ScheduleDto;
import com.bvega.petapigraphql.entity.Employee;
import com.bvega.petapigraphql.entity.Pet;
import com.bvega.petapigraphql.entity.Schedule;
import com.bvega.petapigraphql.repository.EmployeeCrudRepository;
import com.bvega.petapigraphql.repository.PetCrudRepository;
import com.bvega.petapigraphql.repository.ScheduleCrudRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class ScheduleMutationResolver implements GraphQLMutationResolver {

    private final ScheduleCrudRepository scheduleCrudRepository;
    private final EmployeeCrudRepository employeeCrudRepository;
    private final PetCrudRepository petCrudRepository;

    public ScheduleMutationResolver(ScheduleCrudRepository scheduleCrudRepository, EmployeeCrudRepository employeeCrudRepository, PetCrudRepository petCrudRepository) {
        this.scheduleCrudRepository = scheduleCrudRepository;
        this.employeeCrudRepository = employeeCrudRepository;
        this.petCrudRepository = petCrudRepository;
    }

    public Schedule saveSchedule(ScheduleDto scheduleDto){
        Set<Employee> employees = new HashSet<>();
        Set<Pet> pets = new HashSet<>();

        //verify employees exists
        scheduleDto.getEmployeesId().forEach(id -> {
            Optional<Employee> employee = employeeCrudRepository.findById(id);
            try {
                employee.map(employees::add).orElseThrow(ClassNotFoundException::new);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        //verify pets exists
        scheduleDto.getPetsId().forEach(id -> {
            Optional<Pet> pet = petCrudRepository.findById(id);
            try {
                pet.map(pets::add).orElseThrow(ClassNotFoundException::new);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        return scheduleCrudRepository.save(Schedule.builder().date(LocalDate.parse(scheduleDto.getDate()))
                .activities(scheduleDto.getActivities())
                .employees(employees)
                .pets(pets).build());
    }
}
