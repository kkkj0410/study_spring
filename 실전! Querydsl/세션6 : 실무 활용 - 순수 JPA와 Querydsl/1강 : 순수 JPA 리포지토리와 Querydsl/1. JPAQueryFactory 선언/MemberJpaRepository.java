    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public MemberJpaRepository(EntityManager em, JPAQueryFactory queryFactory){
        this.em = em;
        this.queryFactory = queryFactory;
    }
