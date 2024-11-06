@GetMapping("/api/v1/orders")
public List<Order> ordersV1(){
    //목적 : order에 있는 모든 OrderItem을 DB에서 꺼내기
    List<Order> all = orderRepository.findAllByString(new OrderSearch());
    for(Order order : all){
        order.getMember().getName();
        order.getDelivery().getAddress();

        List<OrderItem> orderItems = order.getOrderItems();
        orderItems.stream().forEach(o->o.getItem().getName());
    }

    return all;
}
