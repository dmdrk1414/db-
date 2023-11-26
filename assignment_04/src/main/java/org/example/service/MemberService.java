package org.example.service;

import org.example.entity.Member;
import org.example.repository.MemberRepository;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = new MemberRepository();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
