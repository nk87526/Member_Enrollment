package org.example.com.memberenrollment.controller;

import org.example.com.memberenrollment.Member;
import org.example.com.memberenrollment.exception.ResourceNotFoundException;
import org.example.com.memberenrollment.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Create a new member (accessible to all authenticated users)
    @PostMapping
    public ResponseEntity<String> createMember(@RequestBody Member member) {
        // Validate input data if needed
        // ...

        // Save the member to the database
        memberRepository.save(member);

        return ResponseEntity.ok("Member enrollment successful!");
    }

    // Update a member (accessible only to users with ROLE_ADMIN)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
        // Validate input data if needed
        // ...

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));

        // Update member details
        member.setFirstName(memberDetails.getFirstName());
        member.setLastName(memberDetails.getLastName());
        // ... Update other fields as needed

        // Save the updated member to the database
        memberRepository.save(member);

        return ResponseEntity.ok("Member updated successfully!");
    }

    // Retrieve a member by ID (accessible to all authenticated users)
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));
        return ResponseEntity.ok(member);
    }

    // Retrieve all members (accessible to all authenticated users)
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return ResponseEntity.ok(members);
    }

    // Delete a member by ID (accessible only to users with ROLE_ADMIN)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));

        // Delete the member from the database
        memberRepository.delete(member);

        return ResponseEntity.ok("Member deleted successfully!");
    }
}
