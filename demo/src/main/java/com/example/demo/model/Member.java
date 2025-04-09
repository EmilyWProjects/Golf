package com.example.demo.model;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.*;

import lombok.Data;


@Entity
@Table(name = "members")
@Data 
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String phone;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "membership_duration_months")
    private Integer membershipDurationMonths;

    @ManyToMany(mappedBy = "participatingMembers")
    private Set<Tournament> tournaments = new HashSet<>();
}