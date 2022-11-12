package com.bvega.petapigraphql.entity;

import com.bvega.petapigraphql.util.EmployeeSkillEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity
@Table(name = "t_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "emp_name")
    private String name;
    @ElementCollection(targetClass = EmployeeSkillEnum.class, fetch = FetchType.EAGER)
    @Enumerated
    private Set<EmployeeSkillEnum> skills;
    @ElementCollection(targetClass = DayOfWeek.class, fetch = FetchType.EAGER)
    private Set<DayOfWeek> daysAvailable;
}
