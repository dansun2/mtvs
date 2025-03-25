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
  FROM courses
 WHERE description LIKE "%sunt%";
-- 0.002

-- 이 애플리케이션 사용자들이 강좌 검색기능을 많이 쓰네?
-- 근데 like도 패턴매칭이라 비용이 많이 들어감

CREATE FULLTEXT INDEX idx_courses_title
ON courses(description);

SELECT
	title,
	description
  FROM courses
 WHERE MATCH(description) against("sunt");
-- 0.001s













