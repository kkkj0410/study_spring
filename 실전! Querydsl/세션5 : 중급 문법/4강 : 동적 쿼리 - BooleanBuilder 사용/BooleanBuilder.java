@Test
public void dynamicQuery_BooleanBuilder(){
    String usernameParam = "member1";
    Integer ageParam = 10;

    List<Member> result = searchMember1(usernameParam, ageParam);
    assertThat(result.size()).isEqualTo(1);
}

private List<Member> searchMember1(String usernameCond, Integer ageCond) {
    BooleanBuilder builder = new BooleanBuilder();
    if(usernameCond != null){
        builder.and(member.username.eq(usernameCond));
    }
    if(ageCond != null){
        builder.and(member.age.eq(ageCond));
    }

    return queryFactory
            .selectFrom(member)
            //member.username.eq(usernameCond)
            //member.age.eq(ageCond)
            .where(builder)
            .fetch();
}
