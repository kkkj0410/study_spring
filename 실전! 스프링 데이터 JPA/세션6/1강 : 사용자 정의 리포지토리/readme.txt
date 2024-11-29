### <요약>
- 스프링 데이터 JPA를 상속받으면 해당 객체의 내용을 모두 정의해야한다(Interface 상속)
- 하지만 사용자 정의 리포지토리를 통해, 내가 원하는 내용만 가지는 repostory를 구현할 수 있다.

### 사용자 정의 리포지토리
- 예시
    - 1. MemberRepositoryCustom 
    - 2. MemberRepositoryImpl
      - 스프링 데이터 JPA 리포지토리 + Impl로 이름을 만들어야 인식됨
    - 3. MemberRepository 
      - 1번을 상속받음
      - 2번에서 내가 정의한 내용의 함수를 사용가능해짐
