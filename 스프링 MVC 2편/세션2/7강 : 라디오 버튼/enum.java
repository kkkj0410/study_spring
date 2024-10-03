package hello.itemservice.domain.item;

public enum ItemType {

    BOOK("도서"), FOOD("음식"), ETC("기타");

    private final String description;

    //BOOK(이 안에 있는 값의 타입을 String으로 지정)
    ItemType(String description){
        this.description = description;
    }

}
