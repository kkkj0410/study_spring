### <요약>
- V5에서 쿼리가 총 2번 일어났다
    - OrderQueryDto 1번 + OrderItemQueryDto 1번
- V6는 쿼리를 1번만 사용한다
- 방법
    - OrderQueryDto, OrderItemQueryDto 정보를 모두 담는 새로운 Dto를 만든다
    - 해당 Dto에 규격에 맞게 쿼리 1번으로 데이터를 가져온다
    - 해당 Dto의 내용을 OrderQueryDto 규격에 맞게 필터링 후, OrderQueryDto로 return

---

- Controller
    - OrderFlatDto는 OrderQueryDto, OrderItemQueryDto 정보를 모두 담고 있다
    - OrderFlatDto의 내용을 OrderQueryDto에 맞게 필터링하여 return하는 과정이다.
