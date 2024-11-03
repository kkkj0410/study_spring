@Entity
@Getter @Setter
public class Member {

    @OneToMany(mappedBy = "member")
    @JasonIgnore
    private List<Order> orders = new ArrayList<>();

}
