
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member(124L, "member124");
            em.persist(member);

            em.flush();

						//본래는 tx.commit()이후에 쿼리가 실행되나,
						//em.flush()명령어로 인해, em.flush()에서 쿼리 실행
            System.out.println("==================================");

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
