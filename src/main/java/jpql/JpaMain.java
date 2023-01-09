package jpql;

import java.util.List;
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
//            Member result = em.createQuery("select m from Member m", Member.class)
//                    .getSingleResult();
            // 결과가 1개가 아니면 예외 발생

            List<Member> resultList = em.createQuery("select m from Member m", Member.class)
                    .getResultList();

            for (Member member : resultList) {
                System.out.println("member.getUsername() = " + member.getUsername());
            }

            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
