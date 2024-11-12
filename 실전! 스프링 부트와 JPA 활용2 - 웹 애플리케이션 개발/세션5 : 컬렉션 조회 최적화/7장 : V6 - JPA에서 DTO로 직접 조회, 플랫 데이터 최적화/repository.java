public List<OrderFlatDto> findAllByDto_flat() {
    return em.createQuery(
            "select new "+
                    " jpabook.jpashop.repository.order.query.OrderFlatDto(o.id, m.name, o.orderDate, o.status, d.address, i.name, oi.orderPrice, oi.count)" +
                    " from Order o"+
                    " join o.member m"+
                    " join o.delivery d"+
                    " join o.orderItems oi"+
                    " join oi.item i", OrderFlatDto.class)
            .getResultList();
}
