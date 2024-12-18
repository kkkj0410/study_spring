//constructor -> 생성자에 주입
@Test
public void findDtoByConstructor(){
    List<MemberDto> result = queryFactory
            .select(Projections.constructor(MemberDto.class,
                    member.username,
                    member.age))
            .from(member)
            .fetch();
    for(MemberDto memberDto : result){
        System.out.println("memberDto = " + memberDto);
    }
}
