public List<Order> findAllWithItem(){
    return em.createQuery(
            "select distinct o from Order o" +
            " join fetch o.member m" +
            " join fetch o.delivery d" +
            " join fetch o.orderItems oi"+
            " join fetch oi.item i", Order.class)
            .getResultList();
}
