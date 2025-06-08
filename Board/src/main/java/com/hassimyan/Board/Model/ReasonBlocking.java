package com.hassimyan.Board.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ReasonBlocking {
    @Id
    @GeneratedValue
    private Long id;

    private String reasonBlocking;
    private String reasonUnlock;

    @OneToOne
    private Card card;
}
