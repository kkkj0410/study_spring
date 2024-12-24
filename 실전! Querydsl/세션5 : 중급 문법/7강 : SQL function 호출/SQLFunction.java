@Test
public void sqlFunction(){
    List<String> result = queryFactory
            .select(Expressions.stringTemplate(
                    "function('replace', {0}, {1}, {2})",
                    member.username, "member", "M"))
            .from(member)
            .fetch();

    for(String s : result){
        System.out.println("s = " + s);
    }
    
    //s = M1
		//s = M2
		//s = M3
		//s = M4
}

@Test
public void sqlFunction2(){
    List<String> result = queryFactory
            .select(member.username)
            .from(member)
//                .where(member.username.eq(
//                        Expressions.stringTemplate("function('lower', {0}", member.username)))
            .where(member.username.eq(member.username.lower()))
            .fetch();

    for(String s : result){
        System.out.println("s = " + s);
    }
    
    //s = member1
		//s = member2
		//s = member3
		//s = member4
}
