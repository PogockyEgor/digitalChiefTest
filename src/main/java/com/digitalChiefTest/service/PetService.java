package com.digitalChiefTest.service;

import com.digitalChiefTest.DtoMapper;
import com.digitalChiefTest.domain.Pet;
import com.digitalChiefTest.domain.PetRequestDto;
import com.digitalChiefTest.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    PetRepository petRepository;
    DtoMapper mapper;

    @Autowired
    public PetService(PetRepository petRepository, DtoMapper mapper){
        this.petRepository = petRepository;
        this.mapper = mapper;
    }

    public Pet getPetById(int id){
        return petRepository.findById(id).orElseThrow();
    }

    public Pet createPet(PetRequestDto petReq){
        Pet pet = mapper.fromPetRequestToPet(petReq);
        return petRepository.save(pet);
    }

    public Pet updatePet(PetRequestDto petReq, int id){
        Pet pet = mapper.fromPetRequestToPet(petReq);
        pet.setId(id);
        return petRepository.save(pet);
    }

    public void deletePet(int id){
        petRepository.deleteById(id);
    }
}
