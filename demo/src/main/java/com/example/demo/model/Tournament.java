package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.*;

import lombok.Data;


@Entity
@Table(name = "tournaments")
@Data
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private String location;
    private BigDecimal entryFee;
    private BigDecimal cashPrizeAmount;

    @ManyToMany
    @JoinTable(
        name = "tournament_participants",
        joinColumns = @JoinColumn(name = "tournament_id"),
        inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Member> participatingMembers = new HashSet<>();
}
