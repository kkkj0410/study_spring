- 쿼리 메소드 종류
    - **이름**
    - NamedQuery
    - @Query, 리포지토리 메소드에 쿼리 정의


- 스프링 데이터 JPA를 상속받은 객체는 interface이다.
```java
public interface MemberRepository extends JpaRepository<Member, Long> {
}

```
- 해당 interface를 쓰는데 새로운 함수를 구현하려면 어떻게 해야할까?
- 방법
    - 이름

### 1. 이름으로 함수 구현
- 함수의 이름에 따라 기능을 만들 수 있음
  
- 예시(MemberRepository)
    - And
    - By
        - 조건문
        - find by
        - read by
        - query by
        - get by
        - count by
