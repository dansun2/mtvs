/*
 * select 심화
 * 
 * select란?
 * SQL에서 `SELECT`문을 사용하면 데이터베이스의 실제 테이블에서 데이터를 조회하여 가상의 결과 집합(가상의 테이블)을 형성하는 작업이다.
 * - 이 결과 집합은 쿼리가 실행되는 동안만 존재하며, 실제 데이터베이스의 구조나 데이터에 영향을 주지 않는다.
 * - 실생활 비유 : 친구 명단을 보고 싶을 때, 특정 조건에 따라 친구 목록 필터링
 * */

-- INNER JOIN : 사용자 이름과 권한의 이름 확인
select
	u.username,
	-- roles에서 가져와서 users에서 pk로 사용되는 키
	r.role_name
  from users u
 inner join roles r on u.role_id = r.role_id;

-- ----
/*
 * LEFT JOIN과 RIGHT JOIN
 * - LEFT JOIN : 왼쪽 테이블의 모든 데이터와 오른쪽 테이블의 일치 데이터를 반환 (좌측 테이블 기준)
 * - RIGHT JOIN : 오른쪽 테이블의 모든 데이터와 왼쪽 테이블의 일치 데이터를 반환
 * */

-- LEFT JOIN : 모든 사용자와 강좌를 조회
select
	u.user_id,
	u.username,
	u.role_id,
	c.instructor_id
  from users u
  left join courses c on u.user_id = c.instructor_id
-- 강좌가 없는 학생 제외하고 있는 학생만 보자 (<-> IS NULL)
 WHERE c.instructor_id IS NOT NULL;


-- RIGHT JOIN
SELECT
	u.username,
	c.instructor_id
  FROM users u
 RIGHT JOIN courses c ON u.user_id = c.instructor_id;


/*
📌 미션: courses와 users를 INNER JOIN으로 연결.
   - 조건: 강사 이름과 강좌 제목 조회 -> users.user_id, courses.instructor_id
   - 결과: 강사가 개설한 강좌만 표시.

🎯 힌트: instructor_id와 user_id 연결.
*/






/*
📌 미션: users와 enrollments를 INNER JOIN으로 연결.
   - 조건: 학생 이름과 수강 신청 날짜 조회.
   - 결과: 수강 신청한 학생만 표시.
🎯 힌트: user_id로 연결.
*/




/*
📌 미션: lessons와 courses를 INNER JOIN으로 연결.
   - 조건: 강의 제목과 강좌 제목 조회.
   - 결과: 강좌에 속한 강의만 표시.
🎯 힌트: course_id로 연결.
*/





/*
📌 미션: quizzes와 courses를 INNER JOIN으로 연결.
   - 조건: 퀴즈 제목과 강좌 제목 조회.
   - 결과: 강좌에 속한 퀴즈만 표시.
🎯 힌트: course_id로 연결.
*/





/*
📌 미션: payments와 users를 INNER JOIN으로 연결.
   - 조건: 결제한 학생 이름과 결제 금액 조회.
   - 결과: 결제 기록 있는 사용자만 표시.
🎯 힌트: user_id로 연결.
*/






/*
📌 미션: grades와 courses를 INNER JOIN으로 연결.
   - 조건: 강좌 제목과 최종 점수 조회.
   - 결과: 성적 기록 있는 강좌만 표시.
🎯 힌트: course_id로 연결.
*/




 /*
📌 미션: enrollments와 courses를 LEFT JOIN으로 연결.
   - 조건: 모든 수강 신청과 강좌 제목 조회 (강좌 없는 경우 포함).
   - 결과: course_id 없는 경우 NULL 표시.

🎯 힌트: enrollment_id와 course_id 연결.
*/





/*
📌 미션: enrollments와 courses를 LEFT JOIN으로 연결.
   - 조건: 모든 수강 신청과 강좌 제목 조회 (강좌 없는 경우 포함).
   - 결과: course_id 없는 경우 NULL 표시.
🎯 힌트: enrollment_id와 course_id 연결.
*/






/*
📌 미션: users와 enrollments를 LEFT JOIN으로 연결.
   - 조건: 모든 사용자와 수강 신청 날짜 조회.
   - 결과: 수강 신청 없는 사용자 포함 (NULL).
🎯 힌트: user_id로 연결.
*/





/*
📌 미션: courses와 lessons를 RIGHT JOIN으로 연결.
   - 조건: 모든 강의와 강좌 제목 조회.
   - 결과: 강좌 없는 강의 포함 (NULL).
🎯 힌트: course_id로 연결.
*/






/*
📌 미션: users와 payments를 LEFT JOIN으로 연결.
   - 조건: 모든 사용자와 결제 금액 조회.
   - 결과: 결제 없는 사용자 포함 (NULL).
🎯 힌트: user_id로 연결.
*/







/*
📌 미션: quizzes와 quiz_attempts를 RIGHT JOIN으로 연결.
   - 조건: 모든 퀴즈 시도와 퀴즈 제목 조회.
   - 결과: 시도 없는 퀴즈 포함 (NULL).
🎯 힌트: quiz_id로 연결.
*/









/*
📌 미션: courses와 enrollments를 LEFT JOIN으로 연결.
   - 조건: 모든 강좌와 수강 신청 상태 조회.
   - 결과: 수강 신청 없는 강좌 포함 (NULL).
🎯 힌트: course_id로 연결.
*/

-- --============
-- GROUP BY를 사용하지 않는 경우
-- 강좌별 학생의 숫자를 보고자 하여 아래와 같이 조회를 해보자.
-- count는 단일행이라 강좌별 수를 카운팅 할 수 없음 -> 전체만 가능
-- conkat?은 다중행함수
-- 근데 단일행과 다중행을 같이 쓸 수 없음
SELECT
	c.title "제목",
	c.course_id AS "강좌번호",
--	e.user_id "학번" 이 문제에선 필요 없음
  FROM courses c
 INNER JOIN enrollments e on c.course_id = e.course_id;

-- GROUP BY 두가지의 조건을 하나로 묶어서(ex.학생들중에 강의를 듣고있지 않는 학생은 몇명?)
/*
 * GROUP BY는 쿼리에서 지정한 필드에 대해 같은 값을 가진 행들을 그룹화하는 기능이다.
 * 이를 통해 각 그룹마다 집계 함수 (예 : count, sum, avg)를 사용하여
 * 그룹화된 데이터의 통계 정보를 계산할 수 있다. -> 단일행 함수만 사용가능
 * GROUP BY 구문을 사용하면, 동일한 값을 가진 행들이나 하나의 결과로 묶여
 * 데이터 분석에 유용하게 사용할 수 있다.
 * 
 * 그룹 함수는 여러 개의 행을 하나의 결과로 반환하기 때문에 1:n 관계의 값을 직접 사용할 수 없다.
 * 예를 들어, count와 sum과 같은 집계 함수는 입력한 필드 전체를 대상으로 1개의 결과를 반환한다.
 * 따라서 그룹화된 결과는 1(그룹) : 1(결과) 관계가 형성된다.
 * 
 * 그러나 concat과 같은 문자열 함수는 개별 행의 값을 결합하므로, 그룹 함수와 함께 사용할 경우
 * 예상치 못한 결과가 발생할 수 있다. 이 경우 1(그룹) : n(결과) 관계가 형성되어
 * 결과 테이블의 행 수가 맞지 않아 오류가 발생할 수 있다.
 * */
SELECT
	c.title,
	c.course_id,
	count(e.user_id)
  FROM courses c
  LEFT JOIN enrollments e ON c.course_id = e.course_id
 GROUP BY c.course_id, c.title;
/*
 * courses라는 테이블에서 데이터를 가져올거야 (FROM) 그리고 이 쿼리에서 이 테이블을 c라고 부를거야
 * enrollments라는 테이블은 e라고 부를건데 둘의 공통 컬럼인 course_id를 기준으로 조인할거
 * 	=> 어떤 강좌에 누가 수강신청을 했는지 연결해주기로 함
 * 	=> 조인을 하면 user_id(누가) / course_id(어떤 강좌 번호를) / title(어떤 강의 제목을)
 * 	=> LEFT JOIN을 하면 기준 테이블인 enrollments는 모두 보여줌(수강신청 안 한 사람의 user 정보도 뜸)
 * 강좌별로 묶어서 수강신청한 사람 수를 세어야 함
 * 	1) SELECT에 있는 컬럼들은 GROUP BY로 꼭 묶어줘야 하는 이유 : 묶인 컬럼이 아닌데 SELECT에서 출력하려 하면 오류남
 * 		ex. course_id만 묶었는데 course_id랑 title을 보여줄 때 id는 같은데 title이 다른경우에는?
 * 			어떤 title을 넣어야 할 지 모른다
 * 	2) title만 들어가는 경우가 있나? : 만약 title이 같은 강의가 여러개라면
 * 									GROUP BY 과정에서 서로 다른 course_id를 같이 묶어버리는 경우가 있음
 * 결과를 보여주기로 선택한 데이터는 c.title(강좌제목), c.course_id(강좌id), count(e.user_id 몇명이 신청했는지)
 * */


-- having
-- having은 GROUP BY로 그룹화된 결과에 대한 조건을 설정하는데 사용된다.
-- 이 절은 집계 함수의 결과를 기반으로 필터링을 수행할 수 있도록 해준다.
-- 주어진 쿼리에서는 각 강좌의 수강생 수를 계산하고,
-- 수강생 수가 60명 이상은 강좌만 결과로 포함된다.
-- GROUP BY 절이 실행된 후, having 절이 적용되므로
-- student_count는 count(e.user_id)로 계산된 집계 결과이다.
-- having 절은 where 절과 달리 집계 함수의 결과를 사용할 수 있으며,
-- 원래의 데이터에 대한 필터링은 WHERE 절에서 수행된다.
SELECT
	c.title,
	c.course_id,
	count(e.user_id) AS student_count
  FROM courses c
  INNER JOIN enrollments e ON c.course_id = e.course_id
  GROUP BY c.course_id, c.title
 HAVING student_count >= 60;

-- WHERE 절은 쿼리가 실행될 때 원래의 데이터 행을 필터링하는 데 사용된다.
-- 이 절은 GROUP BY 절이 "실행되기 전"에 적용되기 때문에,
-- 집계 함수인 COUNT(e.user_id)의 결과인 student_count를 참조할 수 없다.
-- 따라서 WHERE 절에서 student_count를 사용할 수 없다.

-- 반면 HAVING 절은 GROUP BY 절이 실행된 후에 적용되기 때문에
-- 이 절은 집계 함수의 결과를 기반으로 필터링할 수 있으며,
-- 따라서 COUNT(e.user_id)로 계산된 student_count를 참조할 수 있다.
-- 이는 HAVING 절이 그룹화된 데이터에 대한 조건을 설정할 수 있게 해준다.

/*
 * 그룹바이의 깊은 개념
 * 그룹바이는 기본적으로 모든 행을 읽고 난 이후에 실행이 된다.
 * 이러한 이유로 인해 내부적으로 I/O가 많이 발생하며, 정렬을 진행하는 과정에서 
 * 중간 결과를 저장하는 행위가 발생하게 되고 이 과정에서 메모리와 디스크 간의 
 * 데이터 이동이 추가로 발생되어 추가적인 I/O가 발생하게 된다.
 * 
 * 그룹화 작업이 수행될 때, 데이터베이스는 원본 테이블의 모든 행을 읽어 
 * 주어진 그룹화 기준에 따라 각 행을 적절한 그룹에 배치해야 한다. 
 * 따라서 데이터의 양이 많을수록 I/O 작업이 증가하게 된다.
 * 
 * 또한, GROUP BY 절은 그룹화된 결과를 정렬해야 하므로, 정렬 작업에도 
 * I/O가 발생한다. 이 과정에서 정렬된 데이터를 메모리에 저장하고, 
 * 필요한 경우 디스크에 임시로 저장하는 과정이 추가적으로 발생할 수 있다.
 * 
 * 이러한 이유로 인해 그룹바이는 인덱스를 통해 자주 그룹화하는 값에 대해 
 * 사전 정렬을 해주는 것이 좋다. 인덱스를 활용하면 전체 테이블 스캔을 
 * 피하고 필요한 데이터에 직접 접근할 수 있어 I/O를 줄이고 
 * 쿼리 성능을 향상시킬 수 있다.
 * 
 * 마지막으로, 데이터베이스의 쿼리 최적화 기법을 활용하여 
 * 그룹화 작업을 최소화하거나 효율적으로 수행하는 것도 
 * 성능을 개선하는 데 중요한 요소이다.
 */

/*
📌 미션: quiz_attempts에서 퀴즈별 평균 점수 계산 -> 퀴즈별로 group by로 묶고 avg쓰기
   - 조건: 평균 점수가 70 이상인 퀴즈만 조회 -> quiz_id랑 score 묶고 having 으로 조건검색
   - 결과: 퀴즈 제목과 평균 점수.
🎯 힌트: GROUP BY와 HAVING 사용.
*/
SELECT
	q.title,
	avg(qa.score) AS 평균점수
  FROM quiz_attempts qa
  LEFT JOIN quizzes q ON qa.quiz_id = q.quiz_id
  GROUP BY q.title, q.quiz_id
 HAVING 평균점수 >=70;



/*
📌 미션: enrollments에서 강좌별 수강생 수 계산. -> 수강신청한 테이블을 강의테이블에 왼쪽조인
   - 조건: 수강생이 2명 이상인 강좌만 조회. -> having으로 counting
   - 결과: 강좌 제목과 수강생 수. -> title, counting된 수강생 수
🎯 힌트: course_id로 그룹화.
*/
SELECT
	c.title,
	count(e.user_id) AS 학생수
  FROM courses c
  INNER JOIN enrollments e ON c.course_id = e.course_id
  GROUP BY c.title
 HAVING 학생수 >= 2;

/*
📌 미션: quiz_attempts에서 사용자별 평균 점수 계산. -> users 테이블을 기준으로 quiz_attempts를 왼쪽조인
   - 조건: 평균 점수가 80 이상인 사용자만 조회. -> avg로 
   - 결과: 사용자 이름과 평균 점수.
🎯 힌트: user_id로 그룹화.
*/
SELECT
	u.username,
	avg(qa.score) AS 평균점수
	FROM quiz_attempts qa 
	INNER JOIN users u ON qa.user_id = u.user_id
	GROUP BY u.username
  HAVING 평균점수 >= 80;

SELECT * FROM lessons;

/*
📌 미션: lessons에서 강좌별 강의 수 계산.
   - 조건: 강의가 3개 이상인 강좌만 조회.
   - 결과: 강좌 제목과 강의 수.
🎯 힌트: course_id로 그룹화.
*/
SELECT
	l.title,
	count(c.course_id) AS 강의수
	FROM lessons l
	INNER JOIN courses c ON c.course_id = l.course_id 
	GROUP BY l.title
  HAVING 강의수 >=3;

SELECT * FROM grades;
SELECT * FROM courses;
/*
📌 미션: grades에서 강좌별 평균 점수 계산.
   - 조건: 평균 점수가 60 이상인 강좌만 조회.
   - 결과: 강좌 제목과 평균 점수.
🎯 힌트: course_id로 그룹화.
*/
SELECT
	c.title,
	avg(g.final_score) AS 평균점수
	FROM grades g
	INNER JOIN courses c ON c.course_id = g.course_id 
	GROUP BY c.course_id
  HAVING 평균점수 >= 60;



/*
📌 미션: users를 가입일순으로 정렬.
   - 조건: 최신 가입자부터 표시.
   - 결과: username과 created_at.

🎯 힌트: ORDER BY와 DESC 사용.
*/



/*
📌 미션: courses를 가격순으로 정렬.
   - 조건: 가장 비싼 강좌부터 표시.
   - 결과: 강좌 제목과 가격.
🎯 힌트: price로 정렬.
*/



/*
📌 미션: payments를 결제 금액순으로 정렬.
   - 조건: 높은 금액부터 표시.
   - 결과: course_id와 amount.
🎯 힌트: amount로 정렬.
*/


/*
📌 미션: quiz_attempts를 점수순으로 정렬.
   - 조건: 낮은 점수부터 표시.
   - 결과: quiz_id와 score.
🎯 힌트: score로 정렬.
*/


/*
📌 미션: lessons를 생성일순으로 정렬.
   - 조건: 최신 강의부터 표시.
   - 결과: title과 created_at.
🎯 힌트: created_at으로 정렬.
*/