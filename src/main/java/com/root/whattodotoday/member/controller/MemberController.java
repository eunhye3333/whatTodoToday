package com.root.whattodotoday.member.controller;

import com.root.whattodotoday.member.domain.Member;
import com.root.whattodotoday.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result){

        if(result.hasErrors()){
            return "members/createMemberForm"; // 에러를 화면에서 뿌려줌
        }

        Member member = new Member();


        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/member/login")
    public String login(){
        return "/member/login";
    }
    

    // @AuthenticationPrincipal User userInfo : 파라미터로 사용하여 멤버 정보 바로 가져오기 (세션을 통하지 않아도 됨)


}
