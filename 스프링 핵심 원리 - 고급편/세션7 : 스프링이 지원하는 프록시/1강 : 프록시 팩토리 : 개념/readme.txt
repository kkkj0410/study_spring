### <요약>

- 프록시 팩토리
    - JDK 프록시 + CGLIB
    - 특징
        - 프록시를 적용할 객체가 인터페이스를 상속받았다면?
            - JDK 프록시를 만듦
        - 프록시를 적용할 객체가 인터페이스를 상속받지 않았다면?
            - CGLIB 만듦
