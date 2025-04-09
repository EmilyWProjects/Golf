package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Member;


public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByNameContainingIgnoreCase(String name);


    List<Member> findByPhone(String phone);


    List<Member> findByMembershipDurationMonths(int duration);


    @Query("SELECT DISTINCT m FROM Member m JOIN m.tournaments t WHERE t.startDate = :startDate")
    List<Member> findByTournamentStartDate(@Param("startDate") LocalDate startDate);
}