/*
* 문제 1: 모든 강좌의 평균 결제 금액을 조회하라.
* 조건: 평균 결제 금액이 50,000원 이상인 강좌만 조회
* 결제하지 않은 강좌도 포함 (금액은 NULL 또는 0)
* 출력: 강좌 제목, 평균 결제 금액
* 힌트: LEFT JOIN, GROUP BY, HAVING 사용
*/
-- 기준은 courses 테이블 (결제가 되고 안 되고 상관 없이 모든 강좌의 금액을 조회해야함)
-- course_id를 기준으로 두 테이블을 조인할건데
-- 강좌 이름별로 grouping 해주면 된다.
-- 나타낼 항목은 강좌제목, amount을 해서 평균치 내기
SELECT
	c.title,
	avg(p.amount) AS 평균가격
	-- COALESCE(컬럼명, 대체할값)는 컬럼에 null값이 있을때 대체할값 으로 변경해줌
  FROM courses c
  LEFT JOIN payments p ON c.course_id = p.course_id
  GROUP BY c.title
 HAVING 평균가격 >= 50000;


/*
* 문제 2: 각 강좌별 평균 퀴즈 점수를 조회하라.
* 조건: 평균 점수가 70점 이상인 강좌만 조회
* 출력: 강좌 제목, 평균 점수
* 힌트: JOIN, GROUP BY, HAVING 사용
*/
-- 기준은 quiz_attempts 테이블
-- quiz_id로 두 테이블을 조인할건데
-- 강좌제목별로 grouping 해주면 된다.
-- 나타낼 항목은 q.title 이랑 avg(qa.score)
-- having 조건으로 >= 70
SELECT
	q.title,
	avg(qa.score) AS 평균퀴즈점수
  FROM courses c
  INNER JOIN quizzes q ON c.course_id = q.course_id
  INNER JOIN quiz_attempts qa ON qa.quiz_id = q.quiz_id
  GROUP BY q.title 
 HAVING 평균퀴즈점수 >=70;
SELECT * FROM quizzes;


