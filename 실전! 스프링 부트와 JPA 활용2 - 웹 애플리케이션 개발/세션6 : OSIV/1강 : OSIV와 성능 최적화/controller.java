@Transactional(readOnly = true)
public class OrderQueryService {
	public List<OrderDto> ordersV2(){
	    List<Order> orders = orderRepository.findAllByString(new OrderSearch());
	    return orders.stream()
	           .map(OrderDto::new)
	           .collect(toList());
}


//@GetMapping("/api/v2/orders")
//public List<OrderDto> ordersV2(){
//    List<Order> orders = orderRepository.findAllByString(new OrderSearch());
//    return orders.stream()
//            .map(OrderDto::new)
//            .collect(toList());
//}
