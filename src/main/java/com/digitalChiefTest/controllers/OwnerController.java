package com.digitalChiefTest.controllers;

import com.digitalChiefTest.domain.Owner;
import com.digitalChiefTest.service.OwnerService;
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
@RequestMapping("/owner")
public class OwnerController {

    OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOwner(@PathVariable int id){
        Owner owner = ownerService.getOwnerById(id);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createOwner(@RequestBody @Valid Owner owner){
        Owner createdOwner = ownerService.createOwner(owner);
        return new ResponseEntity<>(createdOwner, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOwner(@RequestBody @Valid Owner owner, @PathVariable int id){
        Owner updatedOwner = ownerService.updateOwner(owner, id);
        return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable int id){
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
