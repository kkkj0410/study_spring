@Test
public void constant(){
    List<Tuple> result = queryFactory
            .select(member.username, Expressions.constant("A"))
            .from(member)
            .fetch();
    
    for(Tuple tuple : result){
        System.out.println("tuple = " + tuple);
    }
    //tuple = [member1, A]
		//tuple = [member2, A]
		//tuple = [member3, A]
		//tuple = [member4, A]
}


@Test
public void concat(){
    List<String> result = queryFactory
            .select(member.username.concat("_").concat(member.age.stringValue()))
            .from(member)
            .where(member.username.eq("member1"))
            .fetch();

    for(String s : result){
        System.out.println("s = " + s);
    }
    
    //s = member1_10
    //member1의 나이는 10
}
