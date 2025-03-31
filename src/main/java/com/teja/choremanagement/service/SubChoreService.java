package com.teja.choremanagement.service;

import com.teja.choremanagement.model.SubChore;
import com.teja.choremanagement.model.Chore;
import com.teja.choremanagement.repository.SubChoreRepository;
import com.teja.choremanagement.repository.ChoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubChoreService {

    private final SubChoreRepository subChoreRepository;
    private final ChoreRepository choreRepository;

    public SubChoreService(SubChoreRepository subChoreRepository, ChoreRepository choreRepository) {
        this.subChoreRepository = subChoreRepository;
        this.choreRepository = choreRepository;
    }

    // Get all subchores for a given chore ID
    public List<SubChore> getSubChoresByChoreId(int choreId) {
        Optional<Chore> chore = choreRepository.findById(choreId);
        return chore.map(subChoreRepository::findByChore).orElseThrow(() -> new RuntimeException("Chore not found"));
    }

    // Create a new subchore
    public SubChore createSubChore(int choreId, SubChore subChore) {
        Chore chore = choreRepository.findById(choreId)
                .orElseThrow(() -> new RuntimeException("Chore not found"));
        subChore.setChore(chore);
        return subChoreRepository.save(subChore);
    }

    // Delete a subchore by ID
    public void deleteSubChore(int id) {
        if (!subChoreRepository.existsById(id)) {
            throw new RuntimeException("SubChore not found");
        }
        subChoreRepository.deleteById(id);
    }
}
