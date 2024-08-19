### flush

- 쓰기 지연 SQL 저장소안에 쿼리를 실행하고 비움
    - 방법1
        - em.flush()
    - 방법2
        - em.createQuery()

- em.flush()
    - 쓰기 지연 SQL 저장소안에 쿼리를 실행하고 비우는 명령어
    - 쓰기 지연 SQL 저장소 외에, 다른 장소(1차 캐시 등)의 데이터들은 건들지 않음

em.createQuery()
- em.createQuery()가 실행될 때, flush()가 실행됨
- 이유
    - em.persist의 값을 읽기 위해서다.
    - em.createQuery()는 DB에서 데이터를 조회하고 있다
    - 하지만 그 위에 코드를 보면 em.persist를 하여, DB에 값 저장을 시도하고 있다
    - 엄밀히 따지면, em.persist의 내용은 1차 캐시에 저장된다
    - 따라서 em.persist의 객체는 DB에 저장되지 않는다
    - em.createQuery()를 통해, DB에 저장되지 않은 값을 조회하므로, 논리적 오류가 발생
    - 따라서 em.createQuery()에서 자동으로 flush()를 실행하여, em.persist의 값을 읽는다.
