package com.bvega.petapigraphql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class CustomerDto {

    private String name;
    private String phoneNumber;
    private String notes;
}
