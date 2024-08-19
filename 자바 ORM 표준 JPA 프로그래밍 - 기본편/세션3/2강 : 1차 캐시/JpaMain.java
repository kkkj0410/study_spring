package hellojpa;

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

        try{
//            //비영속 상태
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("helloA");
//
//            //영속 상태
//            em.persist(member);

            Member findMember1 = em.find(Member.class,100L);
            Member findMember2 = em.find(Member.class,100L);

            //System.out.println("findMember.name = " + findMember1.getId());

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        em.close();
        emf.close();
    }

}
