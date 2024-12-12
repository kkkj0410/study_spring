/**
 * ex) 회원과 팀을 조인하면서, 팀 이름이 teamA인 팀만 조인, 회원은 모두 조회
 * JPQL : select m from Member m left join m.team t on t.name = 'teamA'
 */
@Test
public void join_on_filtering(){
		//result, result2는 동일한 동작
		//resut2 방식 사용을 추천(where문이 더 가독성이 좋음)

    List<Tuple> result = queryFactory
            .select(member, team)
            .from(member)
            .leftJoin(member.team, team).on(team.name.eq("teamA"))
            .fetch();

    List<Tuple> result2 = queryFactory
            .select(member, team)
            .from(member)
            .join(member.team, team)
            .where(team.name.eq("teamA"))
            .fetch();

    for(Tuple tuple : result){
        System.out.println("tuple : " + tuple);
    }
}

/**
 * 연관관계 없는 엔티티 외부 조인
 * 회원의 이름이 팀 이름과 같은 대상 외부 조인
 */
@Test
public void join_on_no_relation(){

    em.persist(new Member("teamA"));
    em.persist(new Member("teamB"));
    em.persist(new Member("teamC"));

    List<Tuple> result = queryFactory
            .select(member, team)
            .from(member)
            .leftJoin(team).on(member.username.eq(team.name))
            .fetch();

    for(Tuple tuple : result){
        System.out.println("tuple = " + tuple);
    }
}
