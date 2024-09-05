public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();
	
						//정상적으로 member 가져옴
            Member m = em.find(Member.class, member1.getId());

						//team은 프록시 클래스
            System.out.println("m = " + m.getTeam().getClass());

            System.out.println("===========");
            //초기화
            m.getTeam().getName();
            System.out.println("===========");
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
