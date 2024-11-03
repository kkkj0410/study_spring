    @GetMapping("/api/v2/simple-orders")
    public List<SimpleOrderDto> orderV2(){
//        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
//        List<SimpleOrderDto> result = orders.stream()
//                .map(o -> new SimpleOrderDto(o))
//                .collect(Collectors.toList());
        
        //위와 같은 의미
        return orderRepository.findAllByString(new OrderSearch()).stream()
        //각 order 객체를 SimpleOrderDto 자료형 형태로 전달해서, new 객체를 생성하겠다는 의미
        //map을 만든다는 게 아님
                .map(SimpleOrderDto::new)
                //List 형태로 저장
                .collect(Collectors.toList());
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
