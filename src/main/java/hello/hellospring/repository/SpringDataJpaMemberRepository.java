package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/* pk의 데이터 타입 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    /* 규픽 JPQL */
    /* select m from Member m where m.name = ? */
    /* findByNameAndIdOrEmail 등등 추가 가능 */
    Optional<Member> findByName(String name);
}
