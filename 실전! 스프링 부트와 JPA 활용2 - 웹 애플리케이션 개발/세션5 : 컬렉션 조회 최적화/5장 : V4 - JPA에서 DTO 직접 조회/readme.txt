### <목적>
- DB 조회하는 순간에  DTO 타입으로 객체를 생성해서 가져옴

- Repository
    - findOrderQueryDtos()
        - 목적 : OrderQueryDto 전체를 가져오는 것
        1. findOrders()로 OrderQueryDto를 가져옴
        2. 해당 OrderQueryDto 리스트에는 멤버 변수인 OrderItemQueryDto가 정의되어있지 않음
            ⇒ 따라서, findOrderItems()를 통해 OrderItemQueryDto를 가져옴
        ⇒ 각 OrderQueryDto마다 OrderItemQueryDto를 가져오므로 1:N 문제 발생
