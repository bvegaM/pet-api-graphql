package com.bvega.petapigraphql.util.search;

import com.bvega.petapigraphql.util.EmployeeSkillEnum;
import lombok.Data;

import java.util.Set;

@Data
public class SearchEmployee {

    private Set<EmployeeSkillEnum> skills;
    private String daysAvailable;
}
