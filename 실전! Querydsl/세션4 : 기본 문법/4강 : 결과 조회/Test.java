import static study.querydsl.entity.QMember.member;

@Test
public void resultFetch(){
    List<Member> fetch = queryFactory
            .selectFrom(member)
            .fetch();

    Member fetchOne = queryFactory
            .selectFrom(member)
            .fetchOne();

    Member fetchFirst = queryFactory
            .selectFrom(member)
            .fetchFirst();

    QueryResults<Member> results = queryFactory
            .selectFrom(member)
            .fetchResults();

    results.getTotal();
    List<Member> content = results.getResults();

    long total = queryFactory
            .selectFrom(member)
            .fetchCount();

}
