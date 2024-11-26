//Modifying : DB 데이터 수정 시, 필수로 넣어야함 update, delete 쿼리를 만드는 어노테이션
@Modifying
@Query("update Member m set m.age = m.age + 1 where m.age >= :age")
int bulkAgePlus(@Param("age") int age);
