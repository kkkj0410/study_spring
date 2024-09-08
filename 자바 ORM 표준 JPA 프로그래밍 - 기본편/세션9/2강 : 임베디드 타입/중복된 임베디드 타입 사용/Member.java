@Entity
public class Member{
    @Embedded
    private Address homeAddress;
    
    @Embedded
    private Address workAddress;
}
