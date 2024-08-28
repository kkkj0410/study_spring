
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");

						//진짜 매핑에 값을 변경
            member.setTeam(team);

            //team.getMembers().add(member);
            em.persist(member);

            em.flush();
            em.clear();

						
						//team 객체에 있는 list에는 값을 할당하지 않은 상태이다
						//하지만 정상적으로 member 객체들이 출력된다
						//이것이 가능한 이유는 DB의 MEMBER 테이블 값을 가져오기 때문이다.
            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            for(Member m : members){
                System.out.println("m = " + m.getUsername());
            }


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
