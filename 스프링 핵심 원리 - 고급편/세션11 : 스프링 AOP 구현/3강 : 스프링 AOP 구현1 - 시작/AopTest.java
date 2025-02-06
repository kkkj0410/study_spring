@Slf4j
@SpringBootTest
@Import(AspectV1.class)
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

//로그 출력
//2025-02-06T12:39:03.832+09:00  INFO 18640 --- [aop] [    Test worker] hello.aop.order.aop.AspectV1             : [log] void hello.aop.order.OrderService.orderItem(String)
//2025-02-06T12:39:03.836+09:00  INFO 18640 --- [aop] [    Test worker] hello.aop.order.OrderService             : [orderService] 실행
//2025-02-06T12:39:03.838+09:00  INFO 18640 --- [aop] [    Test worker] hello.aop.order.aop.AspectV1             : [log] String hello.aop.order.OrderRepository.save(String)
//2025-02-06T12:39:03.839+09:00  INFO 18640 --- [aop] [    Test worker] hello.aop.order.OrderRepository          : [orderRepository] 실행
//2025-02-06T12:39:03.873+09:00  INFO 18640 --- [aop] [    Test worker] hello.aop.AopTest                        : isAopProxy, orderService=true
//2025-02-06T12:39:03.874+09:00  INFO 18640 --- [aop] [    Test worker] hello.aop.AopTest                        : isAopProxy, orderRepository=true
//2025-02-06T12:39:04.026+09:00  INFO 18640 --- [aop] [    Test worker] hello.aop.order.aop.AspectV1             : [log] void hello.aop.order.OrderService.orderItem(String)
//2025-02-06T12:39:04.027+09:00  INFO 18640 --- [aop] [    Test worker] hello.aop.order.OrderService             : [orderService] 실행
//2025-02-06T12:39:04.027+09:00  INFO 18640 --- [aop] [    Test worker] hello.aop.order.aop.AspectV1             : [log] String hello.aop.order.OrderRepository.save(String)
//2025-02-06T12:39:04.027+09:00  INFO 18640 --- [aop] [    Test worker] hello.aop.order.OrderRepository          : [orderRepository] 실행
