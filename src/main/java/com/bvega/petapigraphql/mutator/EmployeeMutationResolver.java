package com.bvega.petapigraphql.mutator;

import com.bvega.petapigraphql.dto.EmployeeDto;
import com.bvega.petapigraphql.entity.Employee;
import com.bvega.petapigraphql.repository.EmployeeCrudRepository;
import com.bvega.petapigraphql.util.Util;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EmployeeMutationResolver implements GraphQLMutationResolver {

    private final EmployeeCrudRepository employeeCrudRepository;

    public EmployeeMutationResolver(EmployeeCrudRepository employeeCrudRepository) {
        this.employeeCrudRepository = employeeCrudRepository;
    }

    public Employee saveEmployee(EmployeeDto employeeDto){
        return employeeCrudRepository.save(Employee.builder().name(employeeDto.getName())
                .skills(employeeDto.getSkills())
                .daysAvailable(employeeDto.getDaysAvailable()).build());
    }

    public Employee updateEmployee(Long employeeId, Set<String> daysAvailable){
        Optional<Employee> employee = employeeCrudRepository.findById(employeeId);
        if(employee.isPresent()){
            Employee employeeUpdate = employee.get();
            employeeUpdate.getDaysAvailable().addAll(daysAvailable.stream().map(Util::convertDay).collect(Collectors.toSet()));
            return employeeCrudRepository.save(employeeUpdate);
        }else {
            throw new Error("Employee not find");
        }
    }
}
