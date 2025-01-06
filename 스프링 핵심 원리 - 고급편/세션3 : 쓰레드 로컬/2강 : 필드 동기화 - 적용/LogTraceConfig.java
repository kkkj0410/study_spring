@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new FieldLogTrace();
    }
}
