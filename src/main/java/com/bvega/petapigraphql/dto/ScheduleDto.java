package com.bvega.petapigraphql.dto;

import com.bvega.petapigraphql.util.EmployeeSkillEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class ScheduleDto {
    private String date;
    private List<Long> employeesId;
    private List<Long> petsId;
    private List<EmployeeSkillEnum> activities;
}
