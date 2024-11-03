# 1. @JsonIgnore

@JsonIgnore?
- JPA 무한 루프 방지용
- 예시
    - 양방향 관계 : Member ↔ Order
    - Member 객체 안의 Order에 @JsonIgnore를 사용
    - ⇒Member를 불러올 시, Member에 있는 Order는 무시
