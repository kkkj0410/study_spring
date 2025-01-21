@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private final LogTrace logTrace;

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderService.orderItem()");
            //target(비즈니스 로직 객체) 호출
            String result = target.request(itemId);
            logTrace.end(status);

            return result;
        }catch(Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }



    //보안상의 이슈로 noLog 함수는 로그를 찍지 않는 상황
    @Override
    public String noLog() {
        return target.noLog();
    }
}
