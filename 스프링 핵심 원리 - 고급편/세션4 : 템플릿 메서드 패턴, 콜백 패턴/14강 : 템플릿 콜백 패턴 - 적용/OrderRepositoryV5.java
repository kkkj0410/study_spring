@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace logTrace) {
        this.template = new TraceTemplate(logTrace);
    }

    public void save(String itemId){
        template.execute("OrderRepository.save()", () ->{
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외");
            }
            sleep(1000);
            return null;
        });

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
