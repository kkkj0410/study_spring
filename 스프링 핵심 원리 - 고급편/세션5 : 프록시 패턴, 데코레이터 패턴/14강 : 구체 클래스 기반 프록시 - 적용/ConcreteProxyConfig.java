@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace){
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();

        return new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace){
        OrderServiceV2 serviceImpl = new OrderServiceV2(orderRepositoryV2(logTrace));

        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace){
        OrderControllerV2 controllerImpl = new OrderControllerV2(orderServiceV2(logTrace));

        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }


}
