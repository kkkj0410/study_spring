/**
 * 나이가 가장 많은 회원 조회
 */
@Test
public void subQuery(){
	
		//QMember는 자동으로 Member 테이블을 가리킴
		//서브 쿼리에서 Member 테이블을 memberSub이라는 이름으로 사용하기 위해 선언
		//외부 쿼리에서는 Member 테이블을 member라는 이름으로 사용중이기 때문에
		//별도로 구분하기 위해서 내부 쿼리에서는 Member 테이블을 memberSub이름으로 씀
    QMember memberSub = new QMember("memberSub");

    List<Member> result = queryFactory
            .selectFrom(member)
            .where(member.age.eq(
			              //내부 쿼리
                    JPAExpressions
                            .select(memberSub.age.max())
                            .from(memberSub)

            ))
            .fetch();

    assertThat(result).extracting("age")
            .containsExactly(40);
}

/**
 * 나이가 평균 이상인 회원 조회
 */
@Test
public void subQueryGoe(){

    QMember memberSub = new QMember("memberSub");

    List<Member> result = queryFactory
            .selectFrom(member)
            .where(member.age.goe(
                    JPAExpressions
                            .select(memberSub.age.avg())
                            .from(memberSub)

            ))
            .fetch();

    assertThat(result).extracting("age")
            .containsExactly(30,40);
}

/**
 * in절
 */
@Test
public void subQueryIn(){

    QMember memberSub = new QMember("memberSub");

    List<Member> result = queryFactory
            .selectFrom(member)
            .where(member.age.goe(
                    JPAExpressions
                            .select(memberSub.age)
                            .from(memberSub)
                            .where(memberSub.age.gt(10))

            ))
            .fetch();

    assertThat(result).extracting("age")
            .containsExactly(20,30,40);
}

@Test
public void selectSubQuery(){

    QMember memberSub = new QMember("memberSub");

    List<Tuple> result = queryFactory
            .select(member.username,
                    JPAExpressions
                            .select(memberSub.age.avg()))
            .from(memberSub)
            .from(member)
            .fetch();

    for(Tuple tuple : result){
        System.out.println("tuple = " + tuple);
    }
}
