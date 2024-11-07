### 1. 콜렉션 조회 - DTO 변환

- 과정
    - Order 획득
    - Order를 OrderDto로 가공
    - OrderDto안에서 OrderItem 획득
    - OrderItem을 OrderItemDto로 가공
    - 조회

**※ DTO의 목적 상, 엔티티 객체가 외부로 드러나선 안된다**

- 따라서, Order안에 있는 OrderItem도 DTO로 변환해야한다.
- (Address 같은 객체들은 멤버 변수가 변하기 힘들기 때문에 그대로 써도됨)
