SELECT courses.course_id, students.student_name
FROM courses
JOIN students ON courses.student_id = students.student_id;

/*
SELECT - courses에 있는 course_id와 students의 student_name을 선택
FROM - courses로 부터
JOIN - courses 테이블 뿐만 아니라 students 테이블 또한 SELECT의 대상으로 지정
ON - courses의 student_id와 students의 student_id가 같다면 students를 JOIN

*/
