package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;
    private final MemberRepository memberRepository;

    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> searchTournaments(LocalDate startDate, String location) {
        if (startDate != null) return tournamentRepository.findByStartDate(startDate);
        if (location != null) return tournamentRepository.findByLocationContainingIgnoreCase(location);
        return tournamentRepository.findAll();
    }

    public Tournament addParticipant(Long tournamentId, Long memberId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();
        tournament.getParticipatingMembers().add(member);
        return tournamentRepository.save(tournament);
    }

    public Set<Member> getTournamentParticipants(Long tournamentId) {
        Tournament tournament = tournamentRepository
            .findByIdWithParticipants(tournamentId)
            .orElseThrow();
        return tournament.getParticipatingMembers();
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }
    
}