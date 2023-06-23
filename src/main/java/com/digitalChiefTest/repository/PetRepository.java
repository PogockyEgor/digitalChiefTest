package com.digitalChiefTest.repository;

import com.digitalChiefTest.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
