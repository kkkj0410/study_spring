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
            em.clear();

            Member reference = em.getReference(Member.class, member1.getId());
            System.out.println("reference = " + reference.getClass());

						//.getUsername()을 통해 진짜 객체를 조회했으므로, reference는 초기화 된 거임
            reference.getUsername();
            
            // true 반환
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(reference));


            tx.commit();
        }catch(Exception e){
            tx.rollback();
            System.out.println("영속성 컨텍스트 파업");
            e.printStackTrace();
        }finally{
            em.close();
        }

        em.close();
        emf.close();
    }


}
