package jpql;


import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);
            for (int i = 0; i<100; i++){
                Member member = new Member();
                member.setUsername("member"+ i);
                member.setAge(i);
                member.setTeam(team);

                em.persist(member);
            }

            em.flush();
            em.clear();

            List<Member> result = em.createQuery("select m from Member m left join m.team t ", Member.class)
                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


}
