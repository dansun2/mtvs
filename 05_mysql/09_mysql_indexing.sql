-- sql 쿼리 최적화 하는법
-- 1. where절의 조건 최적화
-- 2. sql에 인덱싱 설정 -> 불필요한 탐색 범위를 줄임 ex) ㄱ, ㄴ, ㄷ, ... 이런식으로 유저이름을 나눠둠
-- 		이렇게 해놓고 where 조건에 들어가는것들도 인덱싱이 잡혀있는것들을 넣어주는 경우가 많음

SELECT
	username
  FROM users
 ORDER BY username ASC;
-- pk의 인덱스를 기준으로 순차정렬되어있던것을 username을 기준으로 재정렬함

CREATE INDEX index_enrollments_username
ON users(username);

SELECT
	username
  FROM users
 ORDER BY username ASC;
/*
 * 동작 : username열에 B-tree 인덱스 생성, 검색 속도 향상.
 * 메모리 : 인덱스 데이터 별도 저장, 초기 생성 시 약간의 디스크 사용
 * 결과 : select 실행 시 인덱스 탐색으로 빠름 O(log n)
 * */



/*
 * 복합 인덱스로 다중 조건 검색 개선.
 * 필요성 : username과 password로 자주 검색한다면 단일 인덱스보다 효율적이다.
 * 복합 인덱스는 여러 열을 한 번에 탐색, 풀 스캔 방지
 * */
SELECT * FROM users;
-- 0.061

CREATE INDEX idx_users_username_password
ON users(username, password_hash);

SELECT
	username,
	password_hash
  FROM users
 ORDER BY username ASC,
 password_hash DESC;
-- 0.009s
/*
 * username과 password_hash를 결합한 B-tree 인덱스 생성.
 * 메모리 : 복합 인덱스 저장, 단일 인덱스보다 약간 더 큰 공간
 * */

DROP INDEX idx_users_username_password ON users;

/*
 * B-tree
 * 데이터베이스 파일 시스템에서 널리 사용되는 자가 균형 이진 탐색 트리의 일종으로,
 * 효율적인 데이터 검색, 삽입, 삭제를 지원한다.
 * B-tree는 특히 대량의 데이터를 저장하고 검색하는데 최적화되어 있다.
 * 
 * B-tree란?
 * 균형 트리 구조로, 인덱스 데이터를 효율적으로 저장하고 탐색한다.
 * */

/*
 * FULLTEXT : fullText는 데이터베이스에서 텍스트 검색을 지원하기 위한 기능으로,
 * 대량의 텍스트 데이터에서 특정 단어나 구문을 효율적으로 검색할 수 있도록 설계되었다.
 * FULLTEXT란? : 텍스트 열에서 단어 기반 검색을 위한 인덱스이다.
 * MYSQL 8.4에서 FULLTEXT를 지원하며 MATCH를 사용하여 기준을 정한다.
 * */

-- LIKE절
SELECT 
	* 
  FROM courses;
 WHERE description LIKE "%sunt%";
-- 0.002

-- 이 애플리케이션 사용자들이 강좌 검색기능을 많이 쓰네?
-- 근데 like도 패턴매칭이라 비용이 많이 들어감

CREATE FULLTEXT INDEX idx_courses_titlee
ON courses(description);

SELECT
	title,
	description
  FROM courses
 WHERE MATCH(description) against("sunt");
-- 0.001s

/*
 * hash란 고유 키를 해시값으로 변환해 검색하는 인덱스이다.
 * 	등록 100 -> 해시함수 -> 위치 저장
 * 	조회 100 -> 해시함수 -> 위치 검색
 * -- 하나씩 하는게 아니라 찾고 바로 보내는? 그런거라 굉장히 속도가 빠르다?
 * */

CREATE INDEX idx_payments_amount
ON payments(amount) USING hash;

SELECT 
	*
  FROM payments
 WHERE amount = 417.47;
-- 코드는 O(1) 검색 속도를 갖는다.

/*
 * EXPLAIN
 * 쿼리 실행 계획을 분석해 최적화 포인트를 찾는 도구이다.
 * MYSQL 8.4에서 추가가 되었다.
 * */

EXPLAIN
	SELECT
		*
	  FROM users;
-- select type : 쿼리의 종류
-- table : 쿼리에서 참조하는 테이블
-- type  : 조인의 유형을 나타내며, 쿼리의 성능에 영향을 미치는 요소
-- possible_keys : 쿼리 실행 시 사용할 수 있는 인덱스의 목록
-- key : 실제로 사용된 인덱스의 이름
-- key_len : 사용된 인덱스의 길이를 바이트 단위로 나타낸다.
-- ref : 인덱스가 사용된 경우 어떤 열과 비교하여 인덱스를 사용했는지 나타낸다.
-- rows : 쿼리를 실행하기 위해 데이터베이스가 스택해야 하는 예상 행의 수
-- Extra : 추가적인 정보나 쿼리 실행 시 발생하는 특별한 동작에 대한 설명










