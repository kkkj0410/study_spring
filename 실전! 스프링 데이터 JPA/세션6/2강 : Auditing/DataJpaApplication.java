//Spring Data JPA Auditing 기능 활성화
@EnableJpaAuditing
@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	//생성자, 수정자의 이름을 정하는 역할
	//(실제 어플리케이션을 사용하는 사용자를 통해서 만듦)
	@Bean
	public AuditorAware<String> auditorProvider(){
		return () -> Optional.of(UUID.randomUUID().toString());
	}
}
