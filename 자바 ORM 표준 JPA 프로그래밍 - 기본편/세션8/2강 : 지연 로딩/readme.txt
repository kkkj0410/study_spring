### 지연 로딩?
- 대상을 프록시로 조회하는 기능
- fetch = FetchType.LAZY
- 이점
    - 주로 Member만 조회하고, Member 안의 team을 조회할 일이 없다면 성능에 이점을 얻음

### 즉시 로딩
- 대상을 프록시가 아닌, 즉시 가져오기
- fetch = FetchType.EAGER


### 무엇을 써야하는가?
- 지연 로딩을 써야한다
- 이유
    - 테이블 개수가 많아질 수록 즉시 로딩의 성능이 떨어진다.
    - JPQL에서 N+1 문제를 일으킨다

- JPQL에서 N+1 문제를 일으킨다.
    - DB에 Member 객체를 불렀는데, Member안에 있는 N개의 객체에 대한 SQL 쿼리가 나가게됨

@ManyToOne, @OneToOne은 즉시 로딩이 기본 세팅이라, 지연 로딩으로 바꿔줘야함.
