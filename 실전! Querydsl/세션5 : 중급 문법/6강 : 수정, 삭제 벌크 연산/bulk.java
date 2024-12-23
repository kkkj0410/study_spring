@Test
public void bulkUpdate(){

    //member1 = 10 -> 비회원
    //member2 = 20 -> 비회원
    //member3 = 30 -> 유지
    //member4 = 40 -> 유지

    long count = queryFactory
            .update(member)
            .set(member.username, "비회원")
            .where(member.age.lt(28))
            .execute();

    em.flush();
    em.clear();
}

@Test
public void bulkAdd(){
    long count = queryFactory
            .update(member)
            .set(member.age, member.age.add(1))
            .execute();
}

@Test
public void bulkMultiply(){
    long count = queryFactory
            .update(member)
            .set(member.age, member.age.multiply(2))
            .execute();
    em.flush();
    em.clear();
}

@Test
public void buldDelete(){
    long count = queryFactory
            .delete(member)
            .where(member.age.gt(18))
            .execute();

    em.flush();
    em.clear();
}
