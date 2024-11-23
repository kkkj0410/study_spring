Member findMember1 = new Member("a", 10);
Member findMember2 = new Member("a", 10);
memberRepository.save(findMember1);
memberRepository.save(findMember2);
Member m = memberRepository.findMemberByUsername("a");
