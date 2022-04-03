package com.root.whattodotoday.member.controller;

import com.root.whattodotoday.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 회원가입 창으로 전환
    @GetMapping("/member/new")
    public String signup(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "member/createMemberForm";
    }

    @GetMapping("/member/login")
    public String login(){
        return "/member/login";
    }
    

    // @AuthenticationPrincipal User userInfo : 파라미터로 사용하여 멤버 정보 바로 가져오기 (세션을 통하지 않아도 됨)


}
