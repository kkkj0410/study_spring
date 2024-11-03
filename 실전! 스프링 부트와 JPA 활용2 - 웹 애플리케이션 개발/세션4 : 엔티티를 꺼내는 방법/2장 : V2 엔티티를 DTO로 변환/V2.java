@GetMapping("/api/v2/simple-orders")
public List<SimpleOrderDto> orderV2(){
    //가정 : Order 개수 총 2개(=N)
    //N+1 문제 발생
    //1 = orders 테이블 가져오기
    //N + N = 각 order마다 프록시로 회원, 배송 객체를 지니고 있음. 따라서, 각 order마다 테이블 조회가 2번씩 일어남
    // -> 1 + 회원 N + 배송 N
    return orderRepository.findAllByString(new OrderSearch()).stream()
            .map(SimpleOrderDto::new)
            .collect(Collectors.toList());
}
