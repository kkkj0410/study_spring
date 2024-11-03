- 목적
  - Member, Order가 양방향 관계를 지닐때 생기는 무한 반복 문제를 해결하려고 한다.
  - 해당 문제를 해결하기 위해서는 2가지 방법이 존재한다
  - 1. JsonIgnore
  - 2. 프록시 강제 호출
    

- 문제점
    1. 양방향 무한 반복
        - Order는 Member 객체를 갖는다
        - Member는 Order 객체를 갖는다
        - 서로 조회하고 있으므로, 선언 시 무한 반복 발생
    2. 프록시
        - Order에 있는 Member는 Lazy로 선언되어있다.
        
        ```java
        @ManyToOne(fetch = LAZY)
        @JoinColumn(name = "member_id")
        private Member member;
        ```
        
        - Order 선언 시에, Member는 프록시 상태이므로, member의 값은 없다고 봐도 무방하다.
        - 따라서, 주문 정보를 찾는 과정에서 member 사용 시, null이므로 에러
