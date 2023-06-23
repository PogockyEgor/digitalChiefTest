package com.digitalChiefTest.repository;

import com.digitalChiefTest.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
