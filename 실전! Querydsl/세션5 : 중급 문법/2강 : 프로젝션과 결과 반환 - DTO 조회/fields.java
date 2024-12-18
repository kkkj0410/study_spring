//fields -> getter함수를 거치지 않고 바로 멤버 변수에 주입(private 피하는 방법이 있는 듯)
@Test
public void findDtoByField(){
    List<MemberDto> result = queryFactory
            .select(Projections.fields(MemberDto.class,
                    member.username,
                    member.age))
            .from(member)
            .fetch();
    for(MemberDto memberDto : result){
        System.out.println("memberDto = " + memberDto);
    }
}
