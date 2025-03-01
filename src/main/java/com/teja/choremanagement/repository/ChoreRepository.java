package com.teja.choremanagement.repository;

import com.teja.choremanagement.model.Chore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoreRepository extends JpaRepository<Chore, Integer> {

}
