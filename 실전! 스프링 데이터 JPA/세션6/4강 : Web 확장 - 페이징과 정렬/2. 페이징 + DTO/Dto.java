@Data
public class MemberDto {

    private Long id;
    private String username;
    private String teamName;
    
    public MemberDto(Member member){
        this.id = member.getId();
        this.username = member.getUsername();
    }
}
