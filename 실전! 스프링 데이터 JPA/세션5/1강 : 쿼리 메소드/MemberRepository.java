public interface MemberRepository extends JpaRepository<Member, Long> {
		//select m from Member where name = ? and job = ?
		List<Member> findByNameAndJob;
}
