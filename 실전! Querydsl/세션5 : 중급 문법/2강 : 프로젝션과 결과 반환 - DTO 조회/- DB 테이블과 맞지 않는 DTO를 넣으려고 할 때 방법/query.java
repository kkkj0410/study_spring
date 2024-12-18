@Test
public void findUserDto(){

    QMember memberSub = new QMember("memberSub");

    List<UserDto> result = queryFactory
            .select(Projections.fields(UserDto.class,
                    member.username.as("name"),
                    ExpressionUtils.as(JPAExpressions
                            .select(memberSub.age.max())
                            .from(memberSub), "age")
            ))
            .from(member)
            .fetch();
    for(UserDto userDto : result){
        System.out.println("userDto = " + userDto);
    }
}
