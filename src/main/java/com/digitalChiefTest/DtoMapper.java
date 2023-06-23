package com.digitalChiefTest;

import com.digitalChiefTest.domain.Pet;
import com.digitalChiefTest.domain.PetRequestDto;
import com.digitalChiefTest.repository.OwnerRepository;
import com.digitalChiefTest.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {

    OwnerRepository ownerRepository;

    @Autowired
    public DtoMapper(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    public Pet fromPetRequestToPet(PetRequestDto petRequest){
        Pet pet = new Pet();
        pet.setPetName(petRequest.getPetName());
        pet.setAnimalType(petRequest.getAnimalType());
        pet.setAge(petRequest.getAge());
        pet.setOwner(ownerRepository.findById(petRequest.getOwner()).orElseThrow());
        return pet;
    }
}
