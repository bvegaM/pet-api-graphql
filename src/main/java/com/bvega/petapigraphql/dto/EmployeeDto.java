package com.bvega.petapigraphql.dto;

import com.bvega.petapigraphql.util.EmployeeSkillEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class EmployeeDto {

    private String name;
    private Set<EmployeeSkillEnum> skills;
    private Set<DayOfWeek> daysAvailable;
}
