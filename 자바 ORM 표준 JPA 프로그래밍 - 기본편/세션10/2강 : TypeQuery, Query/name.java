Member result = em.createQuery("select m from Member as m where m.username = :username", Member.class)
    //:username란을 member1으로 바꾸기
    .setParameter("username", "member1")
    //1개의 Entity 리턴
    .getSingleResult();
System.out.println("result = " + result.getUsername());
