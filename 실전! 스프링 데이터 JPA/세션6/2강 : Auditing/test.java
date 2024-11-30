@Test
public void JpaEventBaseEntity() throws InterruptedException {
    Member member = new Member("member1");
    memberRepository.save(member);

    Thread.sleep(100);
    member.setUsername("member2");

    em.flush();
    em.clear();

    Member findMember = memberRepository.findById(member.getId()).get();

    System.out.println("findMember.createdDate = "+ findMember.getCreatedDate());
    System.out.println("findMember.updatedDate = "+ findMember.getLastModifiedDate());
    System.out.println("findMember.getCreatedBy = "+ findMember.getCreatedBy());
    System.out.println("findMember.getLastModifiedBy = "+ findMember.getLastModifiedBy());
}
