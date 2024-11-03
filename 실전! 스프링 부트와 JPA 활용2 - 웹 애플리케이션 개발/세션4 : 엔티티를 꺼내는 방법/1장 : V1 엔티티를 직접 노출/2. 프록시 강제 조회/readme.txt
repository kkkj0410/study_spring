### 2. 프록시 문제

- 방법
    - 프록시 객체를 무시하고 조회한다
    - 프록시 객체를 강제로 실제 객체로 만들어서 조회한다

- 세팅
    - build.gradle
    ```java
    implementation 'com.fasterxml.jackson.datatype:jackson-datatype-hibernate5'
    ```


- (1)프록시 객체를 강제로 실제 객체로 만들어서 조회한다
    - 모든 프록시 객체를 실체로 만드는 코드
```java
@Bean
Hibernate5Module hibernate5Module(){
	Hibernate5Module hibernate5Module = new Hibernate5Module();
	hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
	return hibernate5Module;
}
```

- (2)프록시 객체를 강제로 실제 객체로 만들어서 조회한다
    - 프록시 객체를 강제로 초기화하여 사용
```java
@Bean
Hibernate5Module hibernate5Module(){
	return new Hibernate5Module();
}
```
    
