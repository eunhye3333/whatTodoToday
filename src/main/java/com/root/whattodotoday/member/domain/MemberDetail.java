package com.root.whattodotoday.member.domain;

import com.root.whattodotoday.member.domain.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Setter @Getter
public class MemberDetail implements UserDetails {

    private Long memberNo;
    private String username;
    private String password;
    private String nickname;
    private String auth;

    public MemberDetail(Member member) {
        this.memberNo = member.getMemberNo();
        this.username = member.getId();
        this.password = member.getPw();
        this.nickname = member.getNickname();
        this.auth = "ROLE_" + member.getAuth();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.auth));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}