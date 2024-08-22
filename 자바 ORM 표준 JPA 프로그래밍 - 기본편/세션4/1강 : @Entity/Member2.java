//JPA - DB의 테이블과 매칭할 객체 지정
//기본 - Member라는 이름으로 테이블 MEMBER와 매칭함
@Entity
public class Member {
    @Id
    private Long id;
    private String name;

    public Member(){

    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
