@Query(value = "select m from Member m left join m.team t",
      countQuery = "select count(m) from Member m")
Page<Member> findByAge(int age, Pageable pageable);

Page<Member> page = memberRepository.findByAge(age, pageRequest);
Page<MemberDto> toMap = page.map(m -> new MemberDto(m.getId(), m.getUsername(), null));
