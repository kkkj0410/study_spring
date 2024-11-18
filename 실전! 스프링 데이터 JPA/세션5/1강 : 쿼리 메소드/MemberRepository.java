public interface MemberRepository extends JpaRepository<Member, Long> {
		//select m from Member where name = ? and job = ?
		List<Member> findByNameAndJob;

    //select m Member m(Member 테이블 전체 조회)
    List<Member> findBy;
}
