TypedQuery<Member> query = em.createQuery("select m from Member as m", Member.class);
TypedQuery<String> query2 = em.createQuery("select m.username from Member as m", String.class);

//m.username, m.age는 각각 String, int 타입이므로 TypeQuery 사용 불가
Query query3 = em.createQuery("select m.username, m.age from Member as m");
