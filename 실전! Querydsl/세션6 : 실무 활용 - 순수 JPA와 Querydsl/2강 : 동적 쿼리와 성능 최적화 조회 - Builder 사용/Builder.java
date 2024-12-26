public List<MemberTeamDto> searchByBuilder(MemberSearchCondition condition){

    BooleanBuilder builder = new BooleanBuilder();
    if(StringUtils.hasText(condition.getUsername())){
        builder.and(member.username.eq(condition.getUsername()));
    }
    if(StringUtils.hasText(condition.getTeamName())){
        builder.and(team.name.eq(condition.getTeamName()));
    }

    if(condition.getAgeGoe() != null){
        builder.and(member.age.goe(condition.getAgeGoe()));
    }

    if(condition.getAgeLoe() != null){
        builder.and(member.age.loe(condition.getAgeLoe()));
    }

    return queryFactory
            .select(new QMemberTeamDto(
                    member.id.as("memberId"),
                    member.username,
                    member.age,
                    team.id.as("teamId"),
                    team.name.as("teamName")))
            .from(member)
            .leftJoin(member.team, team)
            .where(builder)
            .fetch();
}
