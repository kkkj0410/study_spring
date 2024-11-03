@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


}
