package com.digitalChiefTest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pets_id_seq_gen")
    @SequenceGenerator(name = "pets_id_seq_gen", sequenceName = "pets_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pet_name")
    private String petName;

    @Column(name = "animal_type")
    private String animalType;

    @Column(name = "age_in_months")
    private int age;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

}
