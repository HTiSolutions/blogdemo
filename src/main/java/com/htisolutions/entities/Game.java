package com.htisolutions.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="date")
    private Date date;

    @NotNull
    @Column(name="winner_id")
    private Long winnerId;

    @NotNull
    @Column(name="loser_id")
    private Long loserId;

    public Game() { }

    public Long getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public Long getWinnerId() {
        return this.winnerId;
    }

    public Long getLoserId() {
        return this.loserId;
    }
}
