@QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
Member findReadOnlyByUsername(String username);


@Test
public void queryHint(){
    //given
    Member member1 = new Member("member1", 10);
    memberRepository.save(member1);
    em.flush();
    em.clear();

    //when
    Member findMember = memberRepository.findReadOnlyByUsername("member1");
	   //해당 member2는 반영되지 않음(읽기 전용이기 때문)
    findMember.setUsername("member2");

    em.flush();
}
