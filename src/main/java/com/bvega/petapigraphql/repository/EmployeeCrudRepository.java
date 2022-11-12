package com.bvega.petapigraphql.repository;

import com.bvega.petapigraphql.entity.Employee;
import com.bvega.petapigraphql.util.EmployeeSkillEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeCrudRepository extends JpaRepository<Employee,Long> {

    List<Employee> findBySkillsInAndDaysAvailable(Set<EmployeeSkillEnum> skills, DayOfWeek day);
}
