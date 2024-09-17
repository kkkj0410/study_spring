//Member, Member 안에 있는 Team 엔티티를 이용한 join
String query = "select m from Member m left join m.team t on t.name = 'teamA'";
List<Member> result = em.createQuery(query, Member.class)
        .getResultList();


//Member, Team 엔티티를 이용한 join
String query = "select m from Member m left join Team t on m.username = t.name";
List<Member> result = em.createQuery(query, Member.class)
        .getResultList();
