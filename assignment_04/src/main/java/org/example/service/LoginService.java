package org.example.service;

import org.example.dto.request.LoginRequest;
import org.example.entity.Member;
import org.example.repository.MemberRepository;

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

    private boolean hasMember(List<Member> members, String email, String password) {
        return members.stream()
                .anyMatch(member -> member.is(email, password));
    }
}
