public List<Order> findAllWithMemberDelivery() {
    return em.createQuery(
            "select o from Order o"+
                    " join fetch o.member m" +
                    " join fetch o.delivery d", Order.class
        ).getResultList();
}
