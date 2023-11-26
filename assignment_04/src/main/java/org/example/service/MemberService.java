package org.example.service;

import org.example.domain.Application;
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

    public Boolean save(Application application) {
        return memberRepository.save(application);
    }
}
