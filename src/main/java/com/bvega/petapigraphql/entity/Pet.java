package com.bvega.petapigraphql.entity;

import com.bvega.petapigraphql.util.PetTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity
@Table(name = "t_pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;
    @Column(name = "pet_name")
    private String name;
    @Column(name = "pet_type")
    private PetTypeEnum type;
    @Column(name = "pet_birth_date")
    private LocalDate birthDate;
    @Column(name = "pet_notes")
    private String notes;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "pet_ctm_id", referencedColumnName = "ctm_id")
    private Customer owner;
}
