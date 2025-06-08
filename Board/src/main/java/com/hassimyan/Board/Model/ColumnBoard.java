package com.hassimyan.Board.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class ColumnBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int columnOrder;

    @Enumerated(EnumType.STRING)
    private TypeColumn type;

    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "currentColumn", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards = new ArrayList<>();
}
