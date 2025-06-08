package com.hassimyan.Board.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate creationDate = LocalDate.now();
    private boolean blocked;

    @ManyToOne
    private ColumnBoard currentColumn;

    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL)
    private ReasonBlocking reasonBlocking;
}
