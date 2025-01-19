@Slf4j
public class DecoratorPatternTest {

    @Test
    void decorator1(){
        Component realComponent = new RealComponent();
        MessageDecorator decorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(decorator);

        client.execute();
    }
}
