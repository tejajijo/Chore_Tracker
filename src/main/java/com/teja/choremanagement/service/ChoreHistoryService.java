package com.teja.choremanagement.service;

import com.teja.choremanagement.model.Chore;
import com.teja.choremanagement.model.ChoreHistory;
import com.teja.choremanagement.model.User;
import com.teja.choremanagement.repository.ChoreHistoryRepository;
import com.teja.choremanagement.repository.SubChoreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChoreHistoryService {

    private final ChoreHistoryRepository choreHistoryRepository;
    private final SubChoreRepository subChoreRepository;

    public ChoreHistoryService(ChoreHistoryRepository choreHistoryRepository, SubChoreRepository subChoreRepository) {
        this.choreHistoryRepository = choreHistoryRepository;
        this.subChoreRepository = subChoreRepository;
    }

    public List<ChoreHistory> getChoreHistoryByUser(User userId) {
        return choreHistoryRepository.findByUserUserId(userId);
    }

    public List<ChoreHistory> getChoreHistoryByChore(Chore choreId) {
        return choreHistoryRepository.findByChoreChoreId(choreId);
    }

    public List<ChoreHistory> getAllChoreHistory() {
        return choreHistoryRepository.findAll();
    }

    public List<ChoreHistory> getCompletedChoresForMonth() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusWeeks(4);
        return choreHistoryRepository.findCompletedChoresForMonth(oneMonthAgo);
    }
}
