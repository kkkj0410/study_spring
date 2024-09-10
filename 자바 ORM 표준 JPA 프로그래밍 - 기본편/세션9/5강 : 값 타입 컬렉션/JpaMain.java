public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new Address("old1","street","1234"));
            member.getAddressHistory().add(new Address("old2","street","5678"));

            em.persist(member);

            em.flush();
            em.clear();

						//값 타입 컬렉션의 데이터 수정
            System.out.println("==============");
            Member findMember = em.find(Member.class, member.getId());

            //favoriteFoods 수정
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

						//addressHistory 수정
            findMember.getAddressHistory().remove(new Address("old1","street","1234"));
            findMember.getAddressHistory().add(new Address("newcity1","street","1234"));

            System.out.println("==============");
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
