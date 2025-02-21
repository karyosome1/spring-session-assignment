package com.example.basic14.auth.service;

import com.example.basic14.auth.dto.AuthLoginRequestDto;
import com.example.basic14.auth.dto.AuthLoginResponseDto;
import com.example.basic14.auth.dto.AuthSignupRequestDto;
import com.example.basic14.member.entity.Member;
import com.example.basic14.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signup(AuthSignupRequestDto dto) {
        Member member = new Member(dto.getEmail());
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public AuthLoginResponseDto login(AuthLoginRequestDto dto) {
        Member member = memberRepository.findByEmail(dto.getEmail()).orElseThrow(
                () -> new IllegalStateException("그런 멤버 없음")
        );
        return new AuthLoginResponseDto(member.getId());
    }
}
