//Member 안에 있는 Team을 가져옴
String query = "select m from Member m inner join m.team t";
List<Member> result = em.createQuery(query, Member.class)
        .setFirstResult(0)
        .setMaxResults(10)
        .getResultList();
