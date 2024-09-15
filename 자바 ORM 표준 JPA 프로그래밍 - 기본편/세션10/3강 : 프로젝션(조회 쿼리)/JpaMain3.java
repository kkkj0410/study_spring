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
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            em.flush();
            em.clear();

            //MemberDTO의 생성자를 통해서 username, age 묶음이 만들어짐
            //jpql.hellojpql.jpql->MemberDTO가 있는 경로 지정
            List<MemberDTO> result = em.createQuery("select new jpql.hellojpql.jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList();

            MemberDTO memberDTO = result.get(0);

            System.out.println("username = " + memberDTO.getUsername());
            System.out.println("age = " + memberDTO.getAge());
 
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
