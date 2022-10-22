package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
//    회원가입 많은 데이터들이 넘어올거 아니에요? post방식을
    @PostMapping("/members/new")
    public String create(MemberPostForm memberPostForm){
        Member member = new Member();
        member.setName(memberPostForm.getName());
//        회원가입로직
        memberService.create(member);
        return "redirect:/";
    }


    //화면에다가 db에서 조회한 값을 넘겨주려면 어떻게?!
    @GetMapping("/members")
    public String memberList(Model model) {
//        key, value 값으로 넘겨줘야한다.
        model.addAttribute("members", memberService.findAll());
        return "members/memberList";
    }

    @GetMapping("/findOne")
    public String findOne(@RequestParam(value="id")Long id, Model model){
        model.addAttribute("member", memberService.findOne(id));
        return "members/memberDetail";
    }
}
