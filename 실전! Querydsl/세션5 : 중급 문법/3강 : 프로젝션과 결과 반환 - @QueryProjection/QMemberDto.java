@Test
public void findDtoByQueryProjection(){
    List<MemberDto> result = queryFactory
            .select(new QMemberDto(member.username, member.age))
            .from(member)
            .fetch();

    for(MemberDto memberDto : result){
        System.out.println("memberDto = " + memberDto);
    }
}
