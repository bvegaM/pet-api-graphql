package com.bvega.petapigraphql.dto;

import com.bvega.petapigraphql.util.PetTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class PetDto {

    private String name;
    private PetTypeEnum type;
    private String birthDate;
    private String notes;
    private Long ownerId;
}
