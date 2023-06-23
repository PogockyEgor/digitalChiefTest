package com.digitalChiefTest.controllers;

import com.digitalChiefTest.domain.Pet;
import com.digitalChiefTest.domain.PetRequestDto;
import com.digitalChiefTest.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController {

    PetService petService;

    @Autowired
    public PetController(PetService petService){
        this.petService = petService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPet(@PathVariable int id){
        Pet pet = petService.getPetById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPet(@RequestBody @Valid PetRequestDto pet){
        Pet createdPet = petService.createPet(pet);
        return new ResponseEntity<>(createdPet, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePet(@RequestBody @Valid PetRequestDto pet, @PathVariable int id){
        Pet updatedPet = petService.updatePet(pet, id);
        return new ResponseEntity<>(updatedPet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable int id){
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
