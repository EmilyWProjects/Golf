package com.example.demo.repository;

import java.time.LocalDate;
import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Tournament;


public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    List<Tournament> findByStartDate(LocalDate startDate);


    List<Tournament> findByLocationContainingIgnoreCase(String location);


    @Query("SELECT t FROM Tournament t LEFT JOIN FETCH t.participatingMembers WHERE t.id = :tournamentId")
    Optional<Tournament> findByIdWithParticipants(@Param("tournamentId") Long tournamentId);
}
