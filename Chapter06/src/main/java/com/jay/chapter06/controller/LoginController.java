package com.jay.chapter06.controller;

import com.jay.chapter06.domain.Member;
import com.jay.chapter06.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("member")
@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public void loginView() {
    }

    @PostMapping("/login")
    public String login(Member member, Model model) {
        Member findMember = memberService.getMember(member);

        if (findMember != null
                && findMember.getPassword().equals(member.getPassword())) {
            model.addAttribute("member", findMember);
            return "forward:getBoardList";
        } else {
            return "redirect:login";
        }
    }

    @GetMapping("logout")
    public String logout(SessionStatus status){
        status.setComplete(); // 세션 강제 종료
        return "redirect:index.html";
    }
}
