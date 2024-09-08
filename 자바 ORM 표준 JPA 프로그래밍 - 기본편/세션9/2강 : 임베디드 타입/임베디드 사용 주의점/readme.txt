임베디드 타입 eqauls() 주의점
1. city, address.city
2. getCity(), address.getCity()
- 2번 방법으로 equals 함수를 짜야함.
- 이유
    - 해당 객체가 프록시 상태일 경우, 지역 변수가 제대로 조회되지 않을 수 있음
    - 따라서 2번 방법으로 확실하게 지역 변수를 DB에서 조회될 수 있도록 해야함
