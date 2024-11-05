@GetMapping("/api/v4/simple-orders")
public List<OrderSimpleQueryDto> orderV4() {
    return orderRepository.findOrderDtos();
}
