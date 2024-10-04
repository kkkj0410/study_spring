@ModelAttribute("deliveryCodes")
public List<DeliveryCode> deliveryCodes(){
    List<DeliveryCode>deliveryCodes = new ArrayList<>();
    deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
    deliveryCodes.add(new DeliveryCode("NORMAL", "일반 배송"));
    deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));

    return deliveryCodes;
}
