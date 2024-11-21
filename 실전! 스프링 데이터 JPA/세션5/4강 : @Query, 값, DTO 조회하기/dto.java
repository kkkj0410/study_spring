@Query("select new study.data_jpa.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t ")
List<MemberDto> findMemberDto();
