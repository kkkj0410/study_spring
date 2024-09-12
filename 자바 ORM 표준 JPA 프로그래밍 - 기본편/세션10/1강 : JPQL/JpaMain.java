public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            List<Member> result = em.createQuery(
                    "select m From Member as m where m.username like '%kim%'",
                    Member.class
            ).getResultList();
            
            for(Member member : result)
            {
                System.out.println("member = " + member);
            }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }

        em.close();
        emf.close();
    }


}
