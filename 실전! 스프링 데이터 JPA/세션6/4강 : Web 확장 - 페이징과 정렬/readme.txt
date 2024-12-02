### <요약>
- 페이징
    - Controller에서 페이징을 시도
- 페이징 + DTO
    - 페이징과 DTO를 동시 적용
- 페이징의 첫 페이지를 1로 적용

### 1. Controller 페이징
- 기본
    - MemberRepository에 page에 대한 별도의 정의 없이 바로 page 형태로 만들기 가능

http://localhost:8080/members?page=0&size=3&sort=id,desc
- page = 0
    - 페이지 0 조회
- size = 3
    - 한 페이지의 데이터 개수
    - (기본은 20개)
- sort=id, desc
    - id의 내림차순 정렬

- 페이징 설정 방법
    - 방법 1 : application.yml
        - 페이지의 기본 데이터 개수는 20
        - yml에서 해당 설정들 변경 가능
    - 방법 2 : Controller에서 설정
        - @PageableDefault
        - (각 페이지의 데이터 개수 변경)


### 2. 페이징 + DTO
- Controller
- DTO

### 3. 페이징의 첫 페이지를 1로 설정
※ 본래 페이징의 첫 페이지는 0부터 시작
- 방법
    1. 직접 클래스 정의해서 첫 페이지를 1로 시작
    2. .yml 설정
1. .yml 설정
    - yml
        - one-indexd-parameters
- 단점
    - 0페이지도 1페이지를 가리킴
        - 즉 0, 1페이지는 서로 같은 처음 페이지
    - 페이지 설정이 0페이지를 기준으로 맞춰져 있음
        - (page=2인데, 설정에서는 페이지 1로 되어있음)
