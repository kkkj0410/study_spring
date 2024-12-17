@Test
public void tupleProjection(){
    List<Tuple> result = queryFactory
            .select(member.username, member.age)
            .from(member)
            .fetch();

    for(Tuple tuple : result){
        String username = tuple.get(member.username);
        Integer age = tuple.get(member.age);

        System.out.println("username = " + username);
        System.out.println("age = " + age);
    }
}
