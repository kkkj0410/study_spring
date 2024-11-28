@Lock(LockModeType.PESSIMISTIC_WRITE)
List<Member> findLockByUsername(String username);

@Test
public void lock(){
    //given
    Member member1 = new Member("member1", 10);
    memberRepository.save(member1);
    em.flush();
    em.clear();

    //when
    List<Member> result = memberRepository.findLockByUsername("member1");

}
