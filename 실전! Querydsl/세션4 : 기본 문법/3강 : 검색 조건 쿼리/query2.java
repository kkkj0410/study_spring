  Member findMember = queryFactory
          .selectFrom(member)
          .where(member.username.eq("member1"),
                  (member.age.eq(10)))
          .fetchOne();
