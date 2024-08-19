

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZ");

            //값 수정 시, persist 쓰면 안됨
            //em.persist(member);

            System.out.println("=============");

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
