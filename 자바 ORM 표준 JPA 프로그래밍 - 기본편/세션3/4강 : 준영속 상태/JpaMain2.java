
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member(125L, "member125");
            member.setName("AAAA");

            em.clear();

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
