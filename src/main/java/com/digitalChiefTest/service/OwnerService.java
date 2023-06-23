package com.digitalChiefTest.service;

import com.digitalChiefTest.domain.Owner;
import com.digitalChiefTest.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    public Owner getOwnerById(int id){
        return ownerRepository.findById(id).orElseThrow();
    }

    public Owner createOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Owner owner, int id){
        owner.setId(id);
        return ownerRepository.save(owner);
    }

    public void deleteOwner(int id){
        ownerRepository.deleteById(id);
    }
}
