package com.bvega.petapigraphql.entity;

import com.bvega.petapigraphql.util.EmployeeSkillEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity
@Table(name = "t_schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sch_id")
    private Long id;
    @Column(name = "sch_date")
    private LocalDate date;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Employee> employees;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Pet> pets;
    @ElementCollection(targetClass = EmployeeSkillEnum.class, fetch = FetchType.EAGER)
    @Enumerated
    private List<EmployeeSkillEnum> activities;
}
