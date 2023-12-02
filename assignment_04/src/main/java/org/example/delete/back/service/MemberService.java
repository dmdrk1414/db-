package org.example.delete.back.service;

import org.example.delete.back.entity.Member;
import org.example.delete.back.repository.MemberRepository;
import org.example.delete.back.domain.Application;

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
