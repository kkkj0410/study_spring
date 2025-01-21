@Configuration
public class InterfaceProxyConfig {

		// Controller 스프링 빈은 프록시 객체이다.
		// 즉, 사용자는 프록시 객체를 받는다.
		// 그 후, 프록시 객체는 실제 비즈니스 로직을 가진 객체를 호출한다
		// 따라서, 사용자 -> 프록시 -> 비즈니스 로직 객체 순으로 호출된다.
    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace){
        OrderControllerV1 controllerImpl = new OrderControllerV1Impl(orderService(logTrace));

        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace){

        OrderRepositoryV1 repositoryImpl = new OrderRepositoryV1Impl();

        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace){

        OrderServiceV1 serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));

        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

}
