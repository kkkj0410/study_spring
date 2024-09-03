public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            //em.clear()는 1차 캐시를 비움.
            //주석 처리했으니, member1은 1차 캐시에 존재
            //em.clear();

            Member reference = em.getReference(Member.class, member1.getId());
            System.out.println("reference = " + reference.getClass());
            //reference는 member1과 동일함
            
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
