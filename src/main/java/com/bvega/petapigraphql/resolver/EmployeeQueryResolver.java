package com.bvega.petapigraphql.resolver;

import com.bvega.petapigraphql.entity.Employee;
import com.bvega.petapigraphql.repository.EmployeeCrudRepository;
import com.bvega.petapigraphql.util.Util;
import com.bvega.petapigraphql.util.search.SearchEmployee;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeQueryResolver implements GraphQLQueryResolver {

    private final EmployeeCrudRepository employeeCrudRepository;

    public EmployeeQueryResolver(EmployeeCrudRepository employeeCrudRepository) {
        this.employeeCrudRepository = employeeCrudRepository;
    }

    public Employee findEmployee(Long id){
        return employeeCrudRepository.findById(id).orElse(null);
    }

    public List<Employee> findEmployeesForService(SearchEmployee searchEmployee){
        return employeeCrudRepository.findBySkillsInAndDaysAvailable(searchEmployee.getSkills(), Util.convertDay(searchEmployee.getDaysAvailable()));
    }
}
