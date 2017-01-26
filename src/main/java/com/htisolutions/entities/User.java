package com.htisolutions.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "nickname")
    private String nickname;

    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public String getNickname() {
        return this.nickname;
    }
}


