package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        /* persist -> 영속화 (영구 저장) */
        /* jpa 가 insert 자동 저장 */
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        /* jpql 객체지향 쿼리 */
        /* pk 기반이 아닌 검색에서는 jpql 사용 */
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        /* jpql 객체지향 쿼리 */
        /* 객체 자체를 조회 */
        return (List<Member>) em.createQuery("select m from Member as m", Member.class)
                .getResultList();
    }
}
