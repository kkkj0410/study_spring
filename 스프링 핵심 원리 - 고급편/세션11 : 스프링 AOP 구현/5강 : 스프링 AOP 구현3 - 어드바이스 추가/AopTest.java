@Slf4j
@SpringBootTest
//@Import(AspectV1.class)
//@Import(AspectV2.class)
@Import(AspectV3.class)
public class AopTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void appInfo(){
        log.info("isAopProxy, orderService={}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, orderRepository={}", AopUtils.isAopProxy(orderRepository));
    }

    @Test
    void success(){
        orderService.orderItem("itemA");
    }

    @Test
    void exception(){
        Assertions.assertThatThrownBy(() -> orderService.orderItem("ex"))
                .isInstanceOf(IllegalStateException.class);
    }
}

//2025-02-07T13:25:37.968+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.aop.AspectV3             : [log] void hello.aop.order.OrderService.orderItem(String)
//2025-02-07T13:25:37.971+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.aop.AspectV3             : [트랜잭션 시작] void hello.aop.order.OrderService.orderItem(String)
//2025-02-07T13:25:37.973+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.OrderService             : [orderService] 실행
//2025-02-07T13:25:37.974+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.aop.AspectV3             : [log] String hello.aop.order.OrderRepository.save(String)
//2025-02-07T13:25:37.975+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.OrderRepository          : [orderRepository] 실행
//2025-02-07T13:25:37.976+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.aop.AspectV3             : [트랜잭션 커밋] void hello.aop.order.OrderService.orderItem(String)
//2025-02-07T13:25:37.976+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.aop.AspectV3             : [리소스 릴리즈] void hello.aop.order.OrderService.orderItem(String)
//2025-02-07T13:25:38.011+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.AopTest                        : isAopProxy, orderService=true
//2025-02-07T13:25:38.012+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.AopTest                        : isAopProxy, orderRepository=true
//2025-02-07T13:25:38.133+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.aop.AspectV3             : [log] void hello.aop.order.OrderService.orderItem(String)
//2025-02-07T13:25:38.133+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.aop.AspectV3             : [트랜잭션 시작] void hello.aop.order.OrderService.orderItem(String)
//2025-02-07T13:25:38.134+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.OrderService             : [orderService] 실행
//2025-02-07T13:25:38.134+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.aop.AspectV3             : [log] String hello.aop.order.OrderRepository.save(String)
//2025-02-07T13:25:38.135+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.OrderRepository          : [orderRepository] 실행
//2025-02-07T13:25:38.136+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.aop.AspectV3             : [트랜잭션 롤벡] void hello.aop.order.OrderService.orderItem(String)
//2025-02-07T13:25:38.137+09:00  INFO 2196 --- [aop] [    Test worker] hello.aop.order.aop.AspectV3             : [리소스 릴리즈] void hello.aop.order.OrderService.orderItem(String)
