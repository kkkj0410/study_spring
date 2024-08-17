### 엔티티?

- DB 테이블과 매칭되는 객체

### 비영속 상태?

- JPA와 연관되지 않은 상태
- 예시
    - Member member = new Member();
    - ⇒ 평범한 자바 코드. JPA와 연관X

### 영속 상태?

- JPA와 연관된 상태
- 예시
    - Member member = new Member();
    - em.persist(member);
    - 영속 컨텍스트(entityManager)라는 곳에 member가 존재하게됨.(JPA와 관련되게 됨)

### 준영속 상태?

- 영속 상태의 객체를 비영속 상태로 만듦
