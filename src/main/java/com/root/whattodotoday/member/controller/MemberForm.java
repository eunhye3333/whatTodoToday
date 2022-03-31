package com.root.whattodotoday.member.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "아이디는 필수입니다")
    private String id;

    @NotEmpty(message = "비밀번호는 필수입니다")
    private String pw;

    private String nickname;
    private String email;
}
