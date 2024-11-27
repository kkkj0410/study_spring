### <요약>
- 목적
    - 패치 조인
- 방법
    - @Query(기존 방법)
    - @EntityGraph

### 1. 기존 패치 조인(@Query)
- 예시
    - 상황
        - Member(N) → Team(1) 조회
        - 지연 로딩된 Team을 조회하기 위해 페치 조인 사용

### 2. 새로운 패치 조인(@EntityGraph)
1. @EntityGraph
    - EntityGraph로 지연 로딩된 테이블을 가져옴
2. @NamedEntityGraph
    - 잘 사용하지않는 기법
    - 이름을 지정해서 team 테이블 가져오기
