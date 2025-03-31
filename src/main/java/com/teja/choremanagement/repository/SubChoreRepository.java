package com.teja.choremanagement.repository;

import com.teja.choremanagement.model.Chore;
import com.teja.choremanagement.model.SubChore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubChoreRepository extends JpaRepository<SubChore, Integer> {
    List<SubChore> findByChore(Chore chore);
}
