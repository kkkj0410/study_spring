@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;

		//매개변수 없는 생성자는 기본으로 필요
    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

 }
