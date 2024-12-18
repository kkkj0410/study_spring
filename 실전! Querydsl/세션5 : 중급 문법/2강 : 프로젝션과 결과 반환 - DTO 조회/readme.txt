### <요약>

- 목적
    - DB에서 받는 내용을 DTO로 바꿔서 받기
- 받는 방법
    - Projections.bean
        - getter함수로 DTO 멤버 변수에 값 주입
    - Projections.fields
        - 별도의 함수 없이 바로 DTO 멤버 변수에 값 주입
    - Projections.constructor
        - 생성자로 DTO 멤버 변수에 값 주입
