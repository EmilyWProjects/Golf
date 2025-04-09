package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Member;
import com.example.demo.model.Tournament;
import com.example.demo.repository.TournamentRepository;
import com.example.demo.service.TournamentService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/tournaments")
@RequiredArgsConstructor
public class TournamentController {
    private final TournamentRepository tournamentRepository;
    private final TournamentService tournamentService;

    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.createTournament(tournament);
    }


    @PostMapping("/{tournamentId}/participants/{memberId}")
    public Tournament addParticipant(
            @PathVariable Long tournamentId,
            @PathVariable Long memberId) {
        return tournamentService.addParticipant(tournamentId, memberId);
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{tournamentId}/participants")
    public Set<Member> getParticipants(@PathVariable Long tournamentId) {
        return tournamentService.getTournamentParticipants(tournamentId);
    }



}