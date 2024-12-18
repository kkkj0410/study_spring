@Test
public void findUserDto(){

    List<UserDto> result = queryFactory
            .select(Projections.fields(UserDto.class,
                    member.username.as("name"),
            ))
            .from(member)
            .fetch();
    for(UserDto userDto : result){
        System.out.println("userDto = " + userDto);
    }
}
