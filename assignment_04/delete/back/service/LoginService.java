package org.example.delete.back.service;

import org.example.delete.back.dto.request.LoginRequest;
import org.example.delete.back.entity.Member;
import org.example.delete.back.repository.MemberRepository;

import java.util.List;

public class LoginService {
    private final MemberRepository memberRepository;

    public LoginService() {
        this.memberRepository = new MemberRepository();
    }

    public Boolean isMember(LoginRequest loginRequest) {
        List<Member> members = memberRepository.findAll();
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        return hasMember(members, email, password);
    }

    public Integer getId(LoginRequest loginRequest) {
        List<Member> members = memberRepository.findAll();
        String email = loginRequest.getEmail();
        Integer id = getId(members, email);

        return id;
    }

    private Integer getId(List<Member> members, String email) {
        return members.stream()
                .filter(member -> member.getEmail().equals(email))
                .findFirst()
                .map(Member::getId)
                .orElse(null);
    }

    private boolean hasMember(List<Member> members, String email, String password) {
        return members.stream()
                .anyMatch(member -> member.is(email, password));
    }
}
