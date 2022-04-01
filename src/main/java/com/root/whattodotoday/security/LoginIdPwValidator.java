package com.root.whattodotoday.security;

import com.root.whattodotoday.member.domain.Member;
import com.root.whattodotoday.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginIdPwValidator implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String insertId) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(insertId);

        if(member == null){
            return null; // throw로 에러를 날리는 게 나을듯
        }

        return User.builder()
                .username(member.getId())
                .password(member.getPw())
                .build();
    }
}
