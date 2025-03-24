/*
 * 서브쿼리
 * 서브쿼리는 쿼리 안에 또 다른 쿼리를 넣어 데이터를 필터링하거나 계산하는 방법이다.
 * 	쿼리를 구분하는게 되게 중요함. 보통 where에 많이 씀
 * 	쿼리를 from절에 쓰면 select에서 선택할곳을 가져오기 위해 무조건 별칭이 필요함
 * 	select에 서브쿼리를 쓰면 성능떨어짐 -> from * <- 떄문에 꼭 컬럼을 지정해주는ㄱ ㅔ 중요
 * => 동적으로 하기 위한 필요성..? ex.인기강좌는 매년 바뀜(동적)
 * select, from, where에 쓰임?
 * 
 * 실생활 비유
 * 친구 중 "운동을 좋아하는 사람"을 찾으려면 먼저 "운동 동아리 명단"을 확인하는 것과 비슷
 * 
 * 사용 유형
 * in -> 서브쿼리 결과에 포함된 값만 반환
 * not in -> 서브쿼리 결과에 없는 값 반환
 * exists -> 서브쿼리의 결과가 존재하면 TRUE
 * 
 * 쿼리 실행 방식
 * 서브쿼리는 내부적으로 임시 결과 집합을 만들어 메모리에 저장한다.
 * 실행 최적화를 위해 인덱스 활용 및 join 대체 가능성을 고려해야 한다.
 * 
 * */

-- WHERE 절에서 서브쿼리 활용

-- 수강 신청한 학생 조회(IN 활용)
SELECT
	username
  FROM users
 WHERE user_id IN ( 
 	SELECT user_id FROM enrollments
 );

-- 수강 신청하지 않은 학생 조회 (not in 활용)
SELECT
	username
  FROM users
 WHERE user_id NOT IN (
 	SELECT user_id FROM enrollments
 );

-- 수강 신청한 학생이 있는지 확인
SELECT
	u.username
	FROM users u
  WHERE exists(
  	SELECT 1 FROM enrollments e WHERE e.user_id = u.user_id 
  );


/*
 * 2. select 절에서 서브쿼리 활용
 * - 문법 : 단일 행, 단일 열 결과만 반환해야 함.
 * - 메모리 : 행별로 서브쿼리 실행, 결과는 캐싱되지 않음.
 * */

-- 학생별 결제 내역과 강좌 평균 가격 조회
SELECT
	u.username,
	p.amount,
	(SELECT 
		avg(p2.amount)
	  FROM payments p2
	 WHERE p2.course_id = p.course_id
	) AS avg_course_payment
  FROM users u 
  INNER JOIN payments p ON u.user_id = p.user_id;
-- 원하는 부분만 드래그해서 쿼리 실행이 가능함
-- 쿼리의 성능을 높이기 위해 무결성 제약조건을 해제하는 경우가 있음
-- 네이티브쿼리가 뭔지 찾아보기

-- 원래 스크립트 파일 내부에서 캐싱이 됨. 그래서 쿼리 성능을 평가할 수 있는 구문으로 따로 확인해야 성능을 정확히 확인 가능
-- 세션단위로 이루어짐. 세션 기준으로 생성되기 때문에 분리를 잘 해줘야 트랜잭션 관리가 원활함

/*
 * 3. From 절에서 서브쿼리 활용
 * 		from 절 서브쿼리란? 임시 테이블(인라인 뷰)을 만들어 쿼리에서 활용
 * - 실생활 비유 : "판매 상위 상품"을 뽑아 그 중 조건에 맞는 것만 분석하는 것과 비슷하다.
 * - 문법 : 서브쿼리에 별칭 필수
 * - 메모리 : 임시 테이블이 메모리에 생성, 대량 데이터 시 디스크 사용 가능
 * - 성능 : 인덱스와 조건 미리 적용으로 최적화 가능
 * */
-- join으로 써야 하는 상황이랑 서브쿼리를 써야 하는 상황이랑 구분 필요
-- limit 는 가장 마지막에 실행됨
SELECT
	sub.course_id,
	sub.avg_amount
  FROM (
  	SELECT
  		course_id,
  		avg(amount) AS avg_amount
  	  FROM payments
 	GROUP BY course_id 
  ) AS sub
  WHERE sub.avg_amount > 100;
