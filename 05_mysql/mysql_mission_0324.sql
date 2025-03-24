/*      윈도우 함수 미션      */
-- 📌 각 강좌에서 상위 3명의 학생을 `RANK()`를 이용해 조회하세요.
-- 
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
-- users랑 quiz_attemps, quizzes 조인해서
-- username이랑 quizzes의 title 출력

SELECT
	sub.*
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