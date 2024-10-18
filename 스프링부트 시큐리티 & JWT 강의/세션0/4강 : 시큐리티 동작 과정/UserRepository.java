//JpaRepository<???,Integer>는 CRUD 함수를 가지고 있음
//따라서, 별도의 함수 정의 없이 ???객체에 대한 변수들 조회하고 수정, 삭제 등에 대한 함수들 획득 
//@Repository라는 어노테이션이 없어도 IoC 가능. 이유는 JpaRepository 상속받았기 때문
public interface UserRepository extends JpaRepository<User,Integer> {

		//새로이 CRUD 함수 만들기
    //findBy 규칙 -> Username문법
    //select * from user where username = ?
    //즉, 함수 이름에 findBy 작성 시, 그 뒤에 적인 변수를 DB에서 찾음
    public User findByUsername(String username);

}
