### <요약>
- 목적
    - 2강에서의 DTO 생성을 더 간편히 하고자 한다
- 방법
    - @QueryProjection
- 장점
    - 2강에서는 복잡하게 갖다 붙여야 됐는데 더 편해짐
    - 인자 잘못 넣으면 에러 표시하기 때문에 오류 잡기 간편해짐
- 단점
    - DTO가 queryDsl에 의존하게 됨
        - 따라서, queryDsl이 없어지면 DTO도 수정해야함

---

- 예시(DTO.java, QMemberDto.java)
    - DTO
        - @QueryProjection을 생성자에다가 붙이면, 해당 생성자에 대한 QMemberDto 생성됨
    - QMemberDto 사용
