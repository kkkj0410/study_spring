
@Entity
public class Member extends BaseEntity{

		//생략
		
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
