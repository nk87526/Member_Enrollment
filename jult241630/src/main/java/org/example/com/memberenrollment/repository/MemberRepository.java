package org.example.com.memberenrollment.repository;

import org.example.com.memberenrollment.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // You can add custom queries or methods here if needed
}
