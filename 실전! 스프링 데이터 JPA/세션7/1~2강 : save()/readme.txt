### <요약>
- 스프링 데이터 JPA를 사용할 때, merge 쿼리가 작동하지 않게 해야한다.

---------------

### 1. 스프링 데이터 JPA - save 함수
- 설명
    - persist : NULL로 설정된 데이터는 persist 쿼리
    - merge : NULL이 아닌 데이터는 merge 쿼리
- 코드(save.java)
    - 스프링 데이터 JPA의 save 함수
    - 해당 엔티티가 NULL이면 if문에 걸려서 persist 실행
- 문제점
    - merge 쿼리의 비효율
        - 데이터를 merge 쿼리로 보내면, DB 테이블에 해당 데이터가 있는지를 확인한다. 만약에 없다면 데이터를 새로 추가한다.
        - ⇒ DB 행을 전부 훑는 비효율적인 쿼리이기 때문에 merge는 사용할 일이 없음
    - 예시
        - item의 id는 String
        - item 선언 시, id의 값을 채우고 save 실행
        - ⇒ 엔티티의 id값이 NULL이 아니기 때문에, merge 쿼리 실행
        @Test
        public void save(){
            Item item = new Item("A");
            itemRepository.save(item);
        }

**※ merge쿼리가 안생기는 예시**
→ @GeneratedValue
- @GeneratedValue는 영속성 컨텍스트까지는 값을 만들지 않음(DB 들어가기 직전에 만듦)
- 따라서, save함수가 실행되도 id는 NULL이니 merge 쿼리 X


### 2. @GeneratedValue없이 merge 방지를 위한 save 함수 사용법
- 방법
    - createdDate 사용
- 코드(useSave.java)
    - createdDate는 DB에 들어가야 만들어지는 데이터
    - 따라서, createdDate가 만들어지기 전에는 merge 동작을 막음
