package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service 스프링 인식
/*@Service*/
public class MemberService {

    /*private final MemberRepository memberRepository = new MemoryMemberRepository();*/
    private final MemberRepository memberRepository;

    // 외부에서 넣어주도록 설정
    // DI
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입
     */
    public Long join(Member member){

        // 중복된 이름 회원 가입 x
        /* 
        Optional<Member> result = memberRepository.findByName(member.getName());
        // ifPresent -> null 이 아닌 값이 있으면 진행한다.
        // Optional 안의 method
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });
        */

        // 중복된 이름 회원 가입 x
        // 위의 내용 최적화
        /*
        memberRepository.findByName(member.getName())
               .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
               });
        */

        // 중복된 이름 회원 가입 x
        // 위의 내용 method화
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    // 중복된 이름 회원 가입 X
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 상세
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
