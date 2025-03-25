/*    WHERE 미션     */
-- 📌 결제한 학생 목록 조회 (IN 활용)
-- 		username을 users테이블에서 뽑아낼건데 그러면 결제(payments)테이블에서 user_id가 있는 사람만 가져와야함
SELECT
	username
  FROM users
  WHERE user_id in(
  	SELECT user_id
  	  FROM payments
  );

-- 📌 퀴즈에 응시하지 않은 학생 목록 조회 (NOT IN 활용)
--		username을 users 테이블에서 뽑아낼건데, quiz_attempts 테이블에서 user_id가 없는 사람만 가져와야됨
SELECT
	username
  FROM users
  WHERE user_id NOT IN (
  	SELECT user_id
  	  FROM quiz_attempts
  );

-- 📌 과제가 있는 강의 목록 조회 (EXISTS 활용)
--		title을 lessons 테이블에서 뽑아낼건데, 그러면 assignments 테이블에서 lesson_id가 있는 강의만 가져와야됨
SELECT
	l.title
  FROM lessons l
  	WHERE EXISTS (
  		SELECT 1 FROM assignments a WHERE a.lesson_id = l.lesson_id 
  	);


/*       SELECT 미션        */
-- 📌 퀴즈 점수와 퀴즈별 평균 점수 비교
--		퀴즈 점수랑 퀴즈별 평균 점수를 가져올건데(select) 그러면 퀴즈 title도 필요함
--		quiz_id가 같은 걸 기준으로 quiz_attempts 테이블에서 score를 가져와서 평균점수를 뽑아주자
SELECT
	q.title,
	qa.score,
	(SELECT
		avg(qa.score)
	  FROM quiz_attempts qa
	 WHERE qa.quiz_id = q.quiz_id
	) AS avg_quiz_score
  FROM quiz_attempts qa
  INNER JOIN quizzes q ON q.quiz_id = qa.quiz_id;
 
-- 📌 결제 금액과 해당 강좌의 수강생 수 출력
-- 		일단 강좌별 결제금액을 뽑아보자
SELECT
	c.title,
	p.amount,
	(SELECT
		count(u.user_id)
	  FROM users u
	 WHERE u.user_id = p.user_id
	) AS student_count
  FROM courses c
  INNER JOIN payments p ON c.course_id = p.course_id;


-- 📌 학생별 평균 결제 금액 조회
-- 		username, payments에서 평균 amount를 가져와야함
SELECT
	u.username,
	(SELECT
		avg(p.amount)
	  FROM payments p
	 WHERE p.user_id = p2.USER_id
	) AS avg_amount
  FROM users u
  INNER JOIN payments p2 ON u.user_id = p2.user_id;


/*        FROM 미션         */
-- 📌 평균 점수보다 높은 퀴즈 조회
--		퀴즈번호, 퀴즈 제목, 평균score
SELECT
	sub.quiz_id,
	q.title,
	sub.avg_score
	FROM (
	  SELECT
		quiz_id,
		avg(score) AS avg_score
	   FROM quiz_attempts
	  GROUP BY quiz_id
	) AS sub
	INNER JOIN quizzes q ON sub.quiz_id = q.quiz_id
  WHERE sub.avg_score > (
  	SELECT 
  	  avg(score) FROM quiz_attempts
  );

-- 📌 결제 총액 평균보다 큰 강좌 조회
--		course의 title을 가져와야 하고, payments의 amount 평균을 내야함
--		일단 강좌별 결제 총액 평균을 내기
SELECT
	sub.course_id,
	c.title,
	sub.avg_amount
	FROM (
		SELECT
		  course_id,
		  avg(amount) AS avg_amount
		 FROM payments
		 GROUP BY course_id
	) AS sub
	INNER JOIN courses c ON c.course_id = sub.course_id
  WHERE sub.avg_amount > (
    SELECT
      avg(amount) FROM payments
  );


-- 📌 평균 과제 수보다 많은 강의 조회
-- 		lesson_id = 1에 assign_id 가 여러개 붙을 수 있음
-- 		lesson_id, avg_assign이 나와야 함
--		lesson별 평균 과제 수를 먼저 구해라

SELECT
	sub.lesson_id,
	sub.title,
	sub.assignment_count 
	FROM (
		SELECT
	  		l.lesson_id,
			l.title,
			count(a.assignment_id) AS assignment_count
		  FROM lessons l
		  INNER JOIN assignments a ON l.lesson_id = a.lesson_id
	  	 GROUP BY l.lesson_id, l.title
	) AS sub
  WHERE sub.assignment_count > (
  	SELECT
  	  count(assignment_id) FROM assignments
  	  WHERE lesson_id = sub.lesson_id
  );
	