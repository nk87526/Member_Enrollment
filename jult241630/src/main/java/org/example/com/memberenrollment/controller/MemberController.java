package org.example.com.memberenrollment.controller;

import org.example.com.memberenrollment.Member;
import org.example.com.memberenrollment.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping("/members")
    public String createMember(@RequestBody Member member) {
        // Validate input data if needed
        // ...

        // Save the member to the database
        memberRepository.save(member);

        return "Member enrollment successful!";
    }
}
