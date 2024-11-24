@Test
public void paging(){
    //given
    memberJpaRepository.save(new Member("member1", 10));
    memberJpaRepository.save(new Member("member2", 10));
    memberJpaRepository.save(new Member("member3", 10));
    memberJpaRepository.save(new Member("member4", 10));
    memberJpaRepository.save(new Member("member5", 10));

    int age = 10;
    int offset = 0;
    int limit = 3;

    //when
    List<Member> members = memberJpaRepository.findByPage(age, offset, limit);
    long totalCount = memberJpaRepository.totalCount(age);

    //then
    assertThat(members.size()).isEqualTo(3);
    assertThat(totalCount).isEqualTo(5);
}
