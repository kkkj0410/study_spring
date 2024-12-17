@Test
public void simpleProjection(){
    List<String> result = queryFactory
            .select(member.username)
            .from(member)
            .fetch();

    for(String s : result){
        System.out.println("s = " + s);
    }
}
