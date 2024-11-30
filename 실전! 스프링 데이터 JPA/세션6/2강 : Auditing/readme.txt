### <요약>
- 목적
    - 각 DB 데이터 행마다 생성일, 수정일, 수정자, 생성자를 넣으려고 한다
    - 해당 데이터의 출처를 확인하는 용도로 사용되므로, 대부분의 DB에는 해당 값들을 넣는다
- Auditing
    - 데이터의 변경사항을 기록하는 것
- Auditing 2가지 방법
    - 순수 JPA
    - 스프링 데이터 JPA


### 1. 실제 Auditing 사용법
- Spring Data JPA 방식으로 구현함
- 다만, (생성일, 수정일), (수정자, 생성자)를 따로 구분함
- (수정자, 생성자)는 (생성일, 수정일)을 상속받음
- ⇒ (생성일, 수정일)은 호불호 없이 쓰이기 때문에 따로 구현함
- ⇒(수정자, 생성자)는 (생성일,수정일)을 넣는 김에 더 넣는 느낌이라서 (생성일, 수정일)을 상속받아서 만듦

생성일, 수정일
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}

수정자, 생성자
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseEntity2 extends BaseEntity {

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;
}
