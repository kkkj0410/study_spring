//bean -> MemberDto의 getter함수를 통해서 값 주입
@Test
public void findDtoBySetter(){
    List<MemberDto> result = queryFactory
            .select(Projections.bean(MemberDto.class,
                    member.username,
                    member.age))
            .from(member)
            .fetch();
    for(MemberDto memberDto : result){
        System.out.println("memberDto = " + memberDto);
    }
}
