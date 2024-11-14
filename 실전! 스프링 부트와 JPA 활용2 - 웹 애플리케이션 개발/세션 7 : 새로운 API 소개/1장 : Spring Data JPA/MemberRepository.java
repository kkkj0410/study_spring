public interface MemberRepository extends JpaRepository<Member, Long> {
    //select m from Member m where m.name
    //JPQL 만듦
    List<Member> findByName(String name);
}
