package com.digitalChiefTest.domain;

import lombok.Data;

@Data
public class PetRequestDto {

    private String petName;
    private String animalType;
    private int age;
    private int owner;
}
