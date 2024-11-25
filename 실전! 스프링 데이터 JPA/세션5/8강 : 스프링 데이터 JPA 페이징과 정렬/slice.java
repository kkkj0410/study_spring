Slice<Member> findSliceByAge(int age, Pageable pageable);

//-----------test----------
Slice<Member> slice = memberRepository.findSliceByAge(age, pageRequest);

//then
List<Member> content = page.getContent();

assertThat(content.size()).isEqualTo(3);
assertThat(slice.getNumber()).isEqualTo(0);
assertThat(slice.isFirst()).isTrue();
assertThat(slice.hasNext()).isTrue();
