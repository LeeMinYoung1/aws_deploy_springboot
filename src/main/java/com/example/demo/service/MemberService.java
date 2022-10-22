package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

//    외부 접근 불가능
    private final MemberRepository repository;


//    생성자
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> findAll(){
        List<Member> result = repository.findAll();
        return result;
    }

    public void create(Member member){
        repository.save(member);
    }

    public Member findOne(Long memberId){
        return repository.findOne(memberId);
    }
}
