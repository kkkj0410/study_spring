package jpql.hellojpql.jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            for(int i = 0; i<100; i++)
            {
                Member member = new Member();
                member.setUsername("member" + i);
                member.setAge(i);
                em.persist(member);
            }

            em.flush();
            em.clear();

            //order by m.age = age 값을 기본(오름차순) 순서대로 선택
            //desc = 내림차순으로 선택
            //.setFirstResult(i) : i번째 index 선택
            //.setMaxResults(i) : i개의 데이터 조회
            //=>0~9 index 데이터 조회
            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
                    .setFirstResult(0)
                    .setMaxResults(10)
                    .getResultList();
            System.out.println("result.size = " + result.size());

            for(Member member1 : result)
            {
                System.out.println("member1 = " + member1);
            }

 
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }

        emf.close();
    }


}
