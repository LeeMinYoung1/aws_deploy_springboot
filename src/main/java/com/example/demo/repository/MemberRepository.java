package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    //=>DB로 바꿀 것이다. h2 DB : java 생태계에서 가볍게 테스트용도로 쓰는 DB
    private static long sequence = 0L;

    public void save(Member member){
//        메모리 변수
        ++sequence;
        member.setId(sequence);
        store.put(sequence, member);
        System.out.println(store);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public Member findOne(Long id) {
        return store.get(id);
    }
}
