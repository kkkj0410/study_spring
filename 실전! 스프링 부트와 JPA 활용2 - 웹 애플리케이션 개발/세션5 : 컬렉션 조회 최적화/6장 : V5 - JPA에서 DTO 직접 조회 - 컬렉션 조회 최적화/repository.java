public List<OrderQueryDto> findAllByDto_optimization() {
    List<OrderQueryDto> result = findOrders();
    
    Map<Long, List<OrderItemQueryDto>> orderItemMap = findOrderItemMap(toOrderIds(result));

    result.forEach(o -> o.setOrderItems(orderItemMap.get(o.getOrderId())));

    return result;
}

private Map<Long, List<OrderItemQueryDto>> findOrderItemMap(List<Long> orderIds) {
    List<OrderItemQueryDto> orderItems =  em.createQuery(
            "select new jpabook.jpashop.repository.order.query.OrderItemQueryDto(oi.order.id, i.name, oi.orderPrice, oi.count)" +
                    " from OrderItem oi" +
                    " join oi.item i" +
                    //oi.order.id가 orderIds에 있다면 가져옴
                    " where oi.order.id in :orderIds", OrderItemQueryDto.class)
            //해당 JPQL 내에서 orderIds라는 변수를 사용할 수 있게 하는 함수
            .setParameter("orderIds", orderIds)
            .getResultList();

    Map<Long, List<OrderItemQueryDto>> orderItemMap = orderItems.stream()
            .collect(Collectors.groupingBy(orderItemQueryDto -> orderItemQueryDto.getOrderId()));
    return orderItemMap;
}

private List<Long> toOrderIds(List<OrderQueryDto> result) {
    List<Long> orderIds = result.stream()
            .map(o->o.getOrderId())
            .collect(Collectors.toList());
    return orderIds;
}
