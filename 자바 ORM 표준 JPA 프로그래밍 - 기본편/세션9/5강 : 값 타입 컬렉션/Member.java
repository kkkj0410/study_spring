@Entity
public class Member{

		//생략

    @ElementCollection
    //FAVORITE_FOOD라는 이름의 테이블 생성
    //MEMBER_ID를 FK로 MEMBER에 JOIN
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
            @JoinColumn(name = "MEMBER_ID")
    )
    //FOOD_NAME을 테이블의 PK로 추가
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();



    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =
            @JoinColumn(name = "MEMBER_ID")
    )
   private List<Address> addressHistory = new ArrayList<>();
   
   
   
}
