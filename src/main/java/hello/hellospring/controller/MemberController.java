package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// @Controller 라는 어노테이션
// Spring Container 에 MemberController 객체를 생성 및 관리
/*
* 스프링 빈을 등록하는 2가지 방법
* 1. 컴포넌트 스캔과 자동 의존관계 설정 --> @Controller, @Service, @Repository
*  --> @Controller, @Service, @Repository 안에서 공부
*  --> component 와 관련된 어노테이션이 있으면 객체 생성하여 컨테이너에 등록
*  --> @Autowired 는 연결
*  --> HelloSpringApplication 하위의 Component만 스캔
* 2. 자바 코드로 직접 스프링 빈 등록
* --> SpringConfig.class 확인
*/

//참고: 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.
//그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다. --> 시도해봄 (@Autowired) 주석
@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자
    // Autowired -> Spring이 MerberService을 연결
    // Controller가 생성될 때, Spring bean에 등록된 Service 객체를 가져온다.
    // DI 의존관계 주입 (3 가지 방법)
    // 1. 생성자 주입
    // 2. @Autowired private MemberService memberService; --> 2. 필드 주입 -> 스프링 시작시 넣어준 뒤, 중간에 바꾸는게 불가능
    // 3. setter 주입
    // @Autowired
    // public void setMemberService(MemberService memberService) { this.memberService = memberService; }
    // --> public 하게 노출이됨
    // 의존관계가 실행 중에 동적으로 변하는 경우가 거의 없으므로 생성자 주입 권장
    /*@Autowired*/
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
