package org.example.back.service;

import org.example.back.entity.Member;
import org.example.back.repository.MemberRepository;
import org.example.back.domain.Application;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = new MemberRepository();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Boolean save(Application application) {
        return memberRepository.save(application);
    }
}
