package hellojpa;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;


    //해당 객체가 다수, 가리키는 대상(team)이 1개라는 뜻
    //많은 Member가 team을 가리키게 만들고 싶다.
    //따라서 @ManyToOne
    @ManyToOne
    //본인 테이블 안에 연결할 변수명 선택
    //team은 DB의 MEMBER의 TEAM_ID에 연결
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    public Team getTeam() {
        return team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team=" + team +
                '}';
    }
}
