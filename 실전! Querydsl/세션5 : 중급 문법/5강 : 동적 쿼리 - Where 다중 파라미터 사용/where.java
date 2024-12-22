@Test
public void dynamicQuery_WhereParam(){
    String usernameParam = "member1";
    Integer ageParam = 10;

    List<Member> result = searchMember2(usernameParam, ageParam);
    assertThat(result.size()).isEqualTo(1);
}

private List<Member> searchMember2(String usernameCond, Integer ageCond) {

    return queryFactory
            .selectFrom(member)
            //where의 인자값이 null이면 해당 조건만 무시됨
            .where(usernameEq(usernameCond), ageEq(ageCond))
            //.where(allEq(usernameCond, ageCond))
            .fetch();
}

private BooleanExpression usernameEq(String usernameCond) {
    return usernameCond == null ? null : member.username.eq(usernameCond);

}
private BooleanExpression ageEq(Integer ageCond) {
    return ageCond != null ? member.age.eq(ageCond) : null;

}

private BooleanExpression allEq(String usernameCond, Integer ageCond){
  return usernameEq(usernameCond).and(ageEq(ageCond));
}
