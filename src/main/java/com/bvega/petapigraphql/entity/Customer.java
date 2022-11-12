package com.bvega.petapigraphql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity
@Table(name = "t_costumers")
public class Customer {

    @Id
    @Column(name = "ctm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ctm_name")
    private String name;
    @Column(name = "ctm_phone")
    private String phoneNumber;
    @Column(name = "ctm_notes")
    private String notes;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Pet> pets;
}
