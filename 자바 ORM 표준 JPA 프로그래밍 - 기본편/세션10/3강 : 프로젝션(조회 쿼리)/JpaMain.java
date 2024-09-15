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

						//해당 쿼리에서 불러들이는 엔티티들은 모두 영속성 컨텍스트에서 관리됨
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            Member findMember = result.get(0);
            findMember.setAge(20);

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
