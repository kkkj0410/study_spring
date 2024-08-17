public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //비영속 상태
            Member member = new Member();
            member.setId(1L);
            member.setName("helloA");

            //영속 상태
            em.persist(member);

            //준영속 상태
            em.detach(member);


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
