package com.example.testjwt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RefreshEntity {

    @Id
    @SequenceGenerator(name = "refresh_sequence", sequenceName = "refresh_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refresh_sequence")
    private Long id;

    private String username;
    private String refresh;
    private String expiration;
}
