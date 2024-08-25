package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@TableGenerator(
        //고유값 생성 제조기 이름 지정
        name = "MEMBER_SEQ_GENERATOR",

        //DB 테이블 지정
        table = "MY_SEQUENCES",

        //primary Key에 대한 값을 MEMBER_SEQ로 지정
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
                generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    public Member(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
