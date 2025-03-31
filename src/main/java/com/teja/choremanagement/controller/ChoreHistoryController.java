package com.teja.choremanagement.controller;

import com.teja.choremanagement.model.Chore;
import com.teja.choremanagement.model.ChoreHistory;
import com.teja.choremanagement.model.User;
import com.teja.choremanagement.service.ChoreHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chore-history")
public class ChoreHistoryController {

    private final ChoreHistoryService choreHistoryService;

    public ChoreHistoryController(ChoreHistoryService choreHistoryService) {
        this.choreHistoryService = choreHistoryService;
    }

    // Fetch all chore history
    @GetMapping
    public ResponseEntity<List<ChoreHistory>> getAllChoreHistory() {
        return ResponseEntity.ok(choreHistoryService.getAllChoreHistory());
    }

    // Fetch chore history by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChoreHistory>> getChoreHistoryByUser(@PathVariable User userId) {
        return ResponseEntity.ok(choreHistoryService.getChoreHistoryByUser(userId));
    }

    // Fetch chore history by chore
    @GetMapping("/chore/{choreId}")
    public ResponseEntity<List<ChoreHistory>> getChoreHistoryByChore(@PathVariable Chore choreId) {
        return ResponseEntity.ok(choreHistoryService.getChoreHistoryByChore(choreId));
    }

    @GetMapping("/completed-month")
    public List<ChoreHistory> getCompletedChoresForMonth() {
        return choreHistoryService.getCompletedChoresForMonth();
    }
}
