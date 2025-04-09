package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> searchMembers(String name, String phone, Integer duration, LocalDate tournamentStartDate) {
        if (name != null) return memberRepository.findByNameContainingIgnoreCase(name);
        if (phone != null) return memberRepository.findByPhone(phone);
        if (duration != null) return memberRepository.findByMembershipDurationMonths(duration);
        if (tournamentStartDate != null) return memberRepository.findByTournamentStartDate(tournamentStartDate);
        return memberRepository.findAll();
    }
}