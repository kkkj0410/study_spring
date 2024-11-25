Page<Member> findByAge(int age, Pageable pageable);

//------Test-------

//given
memberRepository.save(new Member("member1", 10));
memberRepository.save(new Member("member2", 10));
memberRepository.save(new Member("member3", 10));
memberRepository.save(new Member("member4", 10));
memberRepository.save(new Member("member5", 10));

int age = 10;
//Sort.Direction.DESC : 내림차순 정렬
// 0 : 0 페이지
// 3 : 정렬 이후, 한 페이지당 3개의 데이터가 오도록 함
// 0,3 -> member5, member4, member3으로 가지게 됨
PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));

//when
Page<Member> page = memberRepository.findByAge(age, pageRequest);

//then
List<Member> content = page.getContent();
assertThat(content.size()).isEqualTo(3);

//조건을 만족하는 전체 데이터 개수
assertThat(page.getTotalElements()).isEqualTo(5);
//페이지 번호 : 0
assertThat(page.getNumber()).isEqualTo(0);
//페이지 개수 : 2
assertThat(page.getTotalPages()).isEqualTo(2);
//현재 페이지는 첫번째 페이지
assertThat(page.isFirst()).isTrue();
//현재 페이지에서 다음 페이지가 있는지 확인
assertThat(page.hasNext()).isTrue();
