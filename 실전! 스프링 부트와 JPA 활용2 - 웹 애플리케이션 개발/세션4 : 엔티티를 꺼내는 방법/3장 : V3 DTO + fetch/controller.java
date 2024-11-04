@GetMapping("/api/v3/simple-orders")
public List<SimpleOrderDto> orderV3() {
    List<Order> orders = orderRepository.findAllWithMemberDelivery();

    List<SimpleOrderDto> result = orders.stream()
            .map(SimpleOrderDto::new)
            .collect(Collectors.toList());

    return result;
}

@Data
static class SimpleOrderDto{
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    //해당 객체에서는 Order를 그대로 드러내도 상관없음
    //이유는 본 객체가 중요하지 않은 역할이기 때문
    public SimpleOrderDto(Order order) {
        orderId = order.getId();
        name = order.getMember().getName();
        orderDate = order.getOrderDate();
        orderStatus = order.getStatus();
        address = order.getDelivery().getAddress();
    }
}
