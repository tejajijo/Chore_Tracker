package com.teja.choremanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chore_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChoreHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_Id")
    private int entryId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user; // Reference to User

    @ManyToOne
    @JoinColumn(name = "chore_Id", referencedColumnName = "chore_Id")
    private Chore chore; // Reference to Chore

    @ManyToOne
    @JoinColumn(name = "task_Id", referencedColumnName = "task_Id")
    private SubChore subChore; // Reference to SubChore

    @Column(name = "completed_date")
    private LocalDateTime completedDate;

    @Column(name = "isCompleted")
    private boolean isCompleted;
}
