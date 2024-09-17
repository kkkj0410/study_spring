String query = "select m from Member m left join m.team t";
List<Member> result = em.createQuery(query, Member.class)
        .setFirstResult(0)
        .setMaxResults(10)
        .getResultList();
