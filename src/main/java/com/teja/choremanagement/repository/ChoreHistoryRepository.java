package com.teja.choremanagement.repository;

import com.teja.choremanagement.model.Chore;
import com.teja.choremanagement.model.ChoreHistory;
import com.teja.choremanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChoreHistoryRepository extends JpaRepository<ChoreHistory, Integer> {
    List<ChoreHistory> findByUserUserId(User userId);
    List<ChoreHistory> findByChoreChoreId(Chore choreId);
    //List<ChoreHistory> findBySubChoreTaskId(SubChore subChore);  // Fetch by SubChore (New)

    @Query("SELECT ch FROM ChoreHistory ch " +
            "WHERE ch.isCompleted = true AND ch.completedDate >= :startDate")
    List<ChoreHistory> findCompletedChoresForMonth(LocalDateTime startDate);
}
