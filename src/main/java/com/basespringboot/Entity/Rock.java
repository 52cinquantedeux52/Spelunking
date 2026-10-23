package com.basespringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rocks")
@Getter
@Setter
@NoArgsConstructor
public class Rock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Column(nullable = false, length = 60)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RockType type;

    @Column(nullable = false)
    private Integer mohsScale;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false, unique = true, length = 8)
    private String reference;

    @Column(length = 50)
    private String color;

    @Column(length = 90)
    private String discoveredPlace;

    @Column(length = 500)
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Miner owner;
}