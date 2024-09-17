String query = "select m from Member m, Team t where m.username = t.name";
List<Member> result = em.createQuery(query, Member.class)
        .setFirstResult(0)
        .setMaxResults(10)
        .getResultList();
