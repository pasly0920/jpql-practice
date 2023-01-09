package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
/*
            Member result = em.createQuery("select m from Member m", Member.class)
                    .getSingleResult();
            결과가 1개가 아니면 예외 발생
            List<Member> resultList = em.createQuery("select m from Member m", Member.class)
                    .getResultList();

            파라미터 적용
            List<Member> resultList = em.createQuery(
                            "select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "member1")
                    .getResultList();

            실제 sql join이 나갈시 tuning의 요소가 많으므로 조심하기
            List<Team> result = em.createQuery("select t from Member m join m.team t", Team.class)
                    .getResultList();

            DTO를 활용한 다양한 변수 뽑기
            List<MemberDTO> resultList = em.createQuery(
                    "select new jpql.MemberDTO(m.username, m.age) from Member m",
                    MemberDTO.class).getResultList();

            MemberDTO memberDTO = resultList.get(0);

            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());

            페이징
            em.createQuery("select m from Member m order by m.age desc ", Member.class)
                    .setFirstResult(0)
                    .setMaxResults(10)
                    .getResultList();

            //조인 대상 필터링
            String query = "select m, t from Member m LEFT join m.team t on t.name = 'A' ";
            String query2 = "select m from Member m inner join m.team t";
            List<Member> resultList = em.createQuery(query, Member.class)
                    .getResultList();
*/
            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
