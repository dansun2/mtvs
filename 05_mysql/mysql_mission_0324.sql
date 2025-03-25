/*      윈도우 함수 미션      */
-- 📌 각 강좌에서 상위 3명의 학생을 `RANK()`를 이용해 조회하세요.

-- -> 각 강좌라고 했으니까 course_id 별로 묶어준다. (partition by)
-- -> 나는 결제 금액 순서대로 랭크할 예정 (order by amount)
-- -> 내가 보여주고 싶은 정보는 course_id, amount
-- -> 그럼 일단 amount 순으로 순위를 정렬한다.
-- -> 출력해보고 나온것들을 가상의 테이블로 만들어준다
-- -> where절로 조건 준다.

SELECT
	u.username,
	g.final_score,
	RANK() OVER(PARTITION BY course_id ORDER BY final_score DESC) AS rank_value
  FROM grades g
  INNER JOIN users u ON u.user_id = g.user_id;

SELECT 
	sub.username,
	sub.final_score,
	sub.title
	FROM (SELECT
		u.username,
		g.final_score,
		c.title,
		RANK() OVER(PARTITION BY g.course_id ORDER BY final_score DESC) AS rank_value
  	  FROM grades g
     INNER JOIN users u ON u.user_id = g.user_id
     INNER JOIN courses c ON g.course_id = c.course_id
	) sub
  WHERE sub.rank_value <=3;


SELECT
	sub.course_id,
	sub.amount
	FROM (SELECT
  	  course_id,
	  amount,
	  RANK() OVER(PARTITION BY course_id ORDER BY amount DESC) AS rank_value
     FROM payments
	) sub
  WHERE sub.rank_value <= 3;


SELECT
	sub.username,
	sub.amount,
	c.title
	FROM (SELECT
	  p.course_id,
  	  u.username,
	  p.amount,
	  RANK() OVER(PARTITION BY p.course_id ORDER BY p.amount desc) AS rank_value
     FROM payments p
     INNER JOIN users u ON u.user_id = p.user_id
	) sub
  INNER JOIN courses c ON sub.course_id = c.course_id
 WHERE sub.rank_value <= 3;

SELECT
	  p.course_id,
  	  u.username,
	  p.amount,
	  RANK() OVER(PARTITION BY p.course_id ORDER BY p.amount desc) AS rank_value
     FROM payments p
     INNER JOIN users u ON u.user_id = p.user_id;

-- 📌 `DENSE_RANK()`를 이용해 상위 5명까지 출력하고 순위 차이를 비교하세요.
SELECT
	sub.username,
	sub.amount,
	c.title
	FROM (SELECT
	  p.course_id,
  	  u.username,
	  p.amount,
	  RANK() OVER(PARTITION BY p.course_id ORDER BY p.amount desc) AS rank_value
     FROM payments p
     INNER JOIN users u ON u.user_id = p.user_id
	) sub
  INNER JOIN courses c ON sub.course_id = c.course_id
 WHERE sub.rank_value <= 5;

-- 📌 `ROW_NUMBER()`를 이용해 학생별로 최근 응시한 퀴즈 1개만 조회하세요.
-- username, 퀴즈 title, row_num_value 출력
-- join -> quiz_attempts, users, quizzes


SELECT
	sub.username,
	sub.title
	FROM (SELECT
	   u.username,
	   q.title,
	   row_number() over(PARTITION BY qa.quiz_id ORDER BY qa.score DESC) AS row_num_value
      FROM quiz_attempts qa
     INNER JOIN quizzes q ON q.quiz_id = qa.quiz_id
     INNER JOIN users u ON u.user_id = qa.user_id
   ) sub
  WHERE sub.row_num_value < 2;



/*       미션        */
-- 📌 두 개의 강좌를 결제한 후, 첫 번째 결제만 유지하고 두 번째 결제는 취소하세요.
START TRANSACTION;
INSERT INTO payments (user_id, course_id, amount, payment_status)
VALUES (1004, 500, 333.3, 'completed');
SAVEPOINT payment1;

SELECT * FROM payments WHERE user_id = 1004;

INSERT INTO payments (user_id, course_id, amount, payment_status)
VALUES (1004, 501, 333.3, 'completed');

SELECT * FROM payments WHERE user_id = 1004;

ROLLBACK TO SAVEPOINT payment1;
COMMIT;