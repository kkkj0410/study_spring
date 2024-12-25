private final EntityManager em;
private final JPAQueryFactory queryFactory;

public MemberJpaRepository(EntityManager em){
    this.em = em;
    this.queryFactory = new JPAQueryFactory(em);
}
