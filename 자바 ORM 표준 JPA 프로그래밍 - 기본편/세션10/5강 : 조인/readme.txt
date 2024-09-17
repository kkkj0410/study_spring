### 조인(join)

- 정의
    - 서로 다른 두 테이블을 조회하려고 한다
    - 이때, 두 테이블을 조합하여 새로운 테이블을 만든다
    - 이것을 조인이라고 한다
    - 새로운 테이블을 만드는 방법은 각기 다르다
- 종류
    - 내부 조인
        - 조건에 맞는 테이블 데이터만 조합하여 테이블 구성
        - 예시
            - [member.id](http://member.id) = [team.id](http://team.id)인 데이터를 매칭하여 테이블 구성
    - 외부 조인
        - 내부조인 + 조건에 맞지 않는 테이블도 추가
        - 예시
            - [member.id](http://member.id) = team.id인 데이터
            - +
            - [member.id](http://member.id) ≠ team.id인 데이터는 빈 칸을 null로 두고 테이블 생성
            
            ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/9a0c0d89-33bc-42a9-96fd-4b51064a7a84/123b495f-7114-4f6e-bcbf-a24fbac8efb0/Untitled.png)
            
    - 세타 조인
        - 내부 조인은 데이터가 같은(=) 조건만을 사용했음
        - 세타 조인은 =뿐만 아니라, >, <, ≥, ≤ 등 다양한 조건을 추가 가능
        - 예시
            - [member.id](http://member.id) > team.id인 데이터만 새로 만들라





### ON, WHERE

- Join하는 테이블에 조건을 부여하는 문법
- ON
    - JOIN 전에 조건 부여
- WHERE
    - JOIN 후에 조건 부여
- 예시
    - ON
        - A, B 테이블이 있다
        - ON a.name = b.name으로 지정 시,
        - a.name = b.name인 테이블이 새로 만들어진다
    - WHERE
        - A,B 테이블이 있다
        - WHERE a.name = b.name으로 지정 시,
        - 조인한 테이블에서 a.name = b.name인 테이블만 추출된다.
