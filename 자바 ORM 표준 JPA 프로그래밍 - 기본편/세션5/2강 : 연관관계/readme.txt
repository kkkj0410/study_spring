목표 : 객체 안에 객체를 담는 원리 설명

# 객체와 테이블은 서로의 값을 가져오기 위해 어떤 방법을 설계하는가?

객체의 연관관계
- 객체는 단방향 2개로 서로의 객체를 조회한다
- Member : Team team(Member → team으로의 단방향 1개)
- Team : List members(Team → members로의 단방향 1개)
    - 타입이 List인 이유는 Team 1개에 여러개의 Member가 조회하기 때문

DB 테이블의 연관관계
- PK, FK라는 연결점 1개만 있어도 서로 접근 가능(= 방향X)

### FK, PK가 같다는 점을 이용하면, 서로의 테이블에 접근이 가능하다

(연관 관계가 1개만 있어도 가능함)

- 예시
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100)
);

CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    student_id INT,
    course_name VARCHAR(100),
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);


students 테이블을 이용해서 courses의 값 가져오기
SELECT courses.course_id, students.student_name
FROM courses
JOIN students ON courses.student_id = students.student_id;
/*
SELECT - courses에 있는 course_id와 students의 student_name을 선택
FROM - courses로 부터
JOIN - courses 테이블 뿐만 아니라 students 테이블 또한 SELECT의 대상으로 지정
ON - courses의 student_id와 students의 student_id가 같다면 students를 JOIN

*/



courses의 테이블을 이용해서 students의 값 가져오기
SELECT students.student_id, courses.course_id
FROM students
JOIN courses ON courses.student_id = students.student_id;



즉, PK와 FK가 같다는 점을 이용하면, 서로 간의 테이블 값을 가져오기 가능



객체 안의 객체를 수정하려고 한다
- 목적 : 객체 안의 객체 값을 수정하려고 한다
- 예시) Member→ team, Team→members
- Member의 team을 바꾸려면?
    - MEMBER 테이블의 FK로 PK가 있는 TEAM 테이블에 접근하여, 해당 TEAM 테이블의 값 수정
- Team의 membes를 수정하려면?
    - TEAM의 PK로 MEMBER의 FK에 접근하여, 해당 MEMBER 테이블의 값 수정
- PK의 값은 수정 안하나?
    - PK는 개인 값이라 수정 안하는게 좋음
    - 따라서, FK를 수정하고 다른 테이블과 매칭하는 방법을 사용하는 듯함


## FK의 값을 수정하는 주인이 필요하다
- 위의 사진을 보면, Member 객체와 Team 객체 모두 FK에 접근 가능하다.
- 따라서, 1개의 객체에만 FK에 접근할 수 있는 권한을 주려고 한다
- (나머지 1개 객체는 읽기 권한만 부여)
- FK가 있는 객체를 주인으로 사용
- Team은 왜 주인이 되면 안되는가?
    - Team에서 members를 수정 할 시, MEMBER 테이블에서 업데이트 쿼리가 생기게 될 것이다
    - 이는 직관적이지 못한 실행으로, 가독성을 낮추게 된다.

