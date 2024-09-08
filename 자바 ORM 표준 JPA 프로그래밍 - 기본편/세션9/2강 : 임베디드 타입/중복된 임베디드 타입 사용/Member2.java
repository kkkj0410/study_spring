@Entity
public class Member{
    //주소
    @Embedded
    private Address homeAddress;


		//Address 클래스 안에서 쓰이는 변수명을 전부 다 바꿈
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",
                        column=@Column(name = "WORK_CITY")),
            @AttributeOverride(name="street",
                        column=@Column(name = "WORK_STREET")),
            @AttributeOverride(name="zipcode",
                        column=@Column(name = "WORK_ZIPCODE"))
    })
    private Address workAddress;

}
