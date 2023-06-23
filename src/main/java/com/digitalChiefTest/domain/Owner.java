package com.digitalChiefTest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owners_id_seq_gen")
    @SequenceGenerator(name = "owners_id_seq_gen", sequenceName = "owners_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;
}