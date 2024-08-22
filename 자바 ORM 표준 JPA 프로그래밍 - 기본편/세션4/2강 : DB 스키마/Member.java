
//JPA에서 사용하는 클래스임을 명시
@Entity
public class Member {
    @Id
    private Long id;

    @Column(unique = true, length = 10)
    private String name;


}
