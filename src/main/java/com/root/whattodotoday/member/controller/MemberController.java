package com.root.whattodotoday.member.controller;

import com.root.whattodotoday.member.domain.Member;
import com.root.whattodotoday.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes("member")
public class MemberController {
    private final MemberService memberService;

    // 회원가입 창으로 전환
    @GetMapping("/member/new")
    public String signup(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "member/createMemberForm";
    }

    @PostMapping("/member/new")
    public String create(@Valid MemberForm form, BindingResult result){

        if(result.hasErrors()){
            return "member/createMemberForm";
        }

        Member member = new Member();
        member.initMember(form.getId(), form.getPw(), form.getNickname(), form.getEmail());

        memberService.join(member);
        return "redirect:/member/login";
    }

    @GetMapping("/member/login")
    public String loginForm(){
        return "/member/login";
    }

    // @AuthenticationPrincipal User userInfo : 파라미터로 사용하여 멤버 정보 바로 가져오기 (세션을 통하지 않아도 됨)

    @PostMapping("/member/loginProc")
    public String login(@ModelAttribute MemberForm memberForm, Model model){
        Member member = memberService.findOne(memberForm);

        if(member != null) {
            model.addAttribute("member", member);
            return "redirect:/todo/list";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:index.html";
    }


}
