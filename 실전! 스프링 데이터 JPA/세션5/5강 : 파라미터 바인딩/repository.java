// :names -> 파라미터의 값을 names에 첨가
@Query("select m from Member m where m.username in :names")
//Collection -> ArrayList, Set 등의 서로다른 자료구조가 와도 받을 수 있는 타입
List<Member> findByNames(@Param("names") Collection<String> names);
