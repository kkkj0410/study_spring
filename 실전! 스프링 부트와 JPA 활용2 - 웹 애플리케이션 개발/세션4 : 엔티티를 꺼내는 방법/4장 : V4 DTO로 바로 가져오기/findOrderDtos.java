public List<OrderSimpleQueryDto> findOrderDtos(){
    return em.createQuery(
            "select new jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto(o.id, m.name, o.orderDate, o.status, d.address) from Order o" +
                    " join o.member m" +
                    " join o.delivery d", jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto.class)
            .getResultList();
}
