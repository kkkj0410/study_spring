List<Member> result = memberRepository.findListByUsername("XXX");
System.out.println("result = " + result.size());
//0

Member findMember = memberRepository.findMemberByUsername("XXX");
System.out.println("findMember = " + findMember);
//null
