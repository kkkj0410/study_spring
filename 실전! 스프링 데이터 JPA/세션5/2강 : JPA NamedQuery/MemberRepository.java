public interface MemberRepository extends JpaRepository<Member, Long> {
		//name은 아무 기능 없음(식별자 역할)
		
		//select m from Member m where m.username = :username
		//-> username을 인자로 받아서, 해당 인자와 같은 member를 꺼냄
    @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);
}
