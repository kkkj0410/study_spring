package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    private Long id;


    //배송지 주소
    private String city;
    private String street;
    private String zipcode;

    //배송 현황
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Order order;
}
