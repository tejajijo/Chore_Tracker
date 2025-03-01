package com.teja.choremanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="chores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chore_Id;

    @Column(name = "chor_Name", nullable = false)
    private String chore_Name;

}
