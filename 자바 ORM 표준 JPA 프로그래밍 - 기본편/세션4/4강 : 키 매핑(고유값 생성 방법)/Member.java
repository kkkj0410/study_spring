package hellojpa;

import javax.persistence.*;
import java.util.Date;

//JPA에서 사용하는 클래스임을 명시
@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private int id;

    @Column(name = "username")
    private String username;

    public Member(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
