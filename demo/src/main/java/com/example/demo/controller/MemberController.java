package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/search")
    public List<Member> searchMembers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) Integer duration,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        if (name != null) return memberRepository.findByNameContainingIgnoreCase(name);
        if (phone != null) return memberRepository.findByPhone(phone);
        if (duration != null) return memberRepository.findByMembershipDurationMonths(duration);
        if (startDate != null) return memberRepository.findByTournamentStartDate(startDate);
        return memberRepository.findAll();
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }
}
