show tables;

select * from roles;

select count(*) from quiz_attempts;
/*
 * SQL 기본 문법
 * - SELECT : 데이터를 조회하는 명령어
 * - INSERT : 데이터를 추가하는 명령어
 * - UPDATE : 데이터를 수정하는 명령어
 * - DELETE : 데이터를 삭제하는 명령어
 * */

-- INSERT : 데이터 추가
insert into roles (role_name)
-- 내가 넣을 값
values ("test_role");

-- SELECT : 데이터 조회
select
	role_id,
	role_name
 from roles;

-- UPDATE : 데이터 수정. set뒤에는 컬럼과 값
update
	roles
   set role_name="delete_role"
 where role_id=4;

-- DELETE : 데이터 삭제
delete from roles where role_id = 4;

select * from roles;


-- 다중 INSERT. 근데 입력은 컬럼의 순서가 중요하지 않지만 value를 넣을때는 내가 적은 컬럼의 순서가 중요하다.
insert into users(username, email, password_hash, role_id)
values
	("bob", "bob@gmail.com", "hash5454", 1),
	("cathy", "cathy@gmail.com", "hash2323", 3);

select * from users;
SELECT * FROM roles;

/*
📌 미션: courses 테이블로 SQL 기본 문법 연습.
   
조건:
roles에서 강사 권한의 Id를 찾는다. -> select로 role_name이 Instructor인 값을 찾음
users에 신규 강사 추가한다. -> insert, value
courses에 추가된 강사가 진행하는 2개 강좌를 추가. -> 추가된 강사의 user_id를 알아야됨 
											같은 강사니까 instructor_id가 같음 = instructor_id가 user_id인가?
추가된 강좌의 이름을 수정_000으로 변경한다. ->
🎯 힌트: 외래키 제약조건 주의!
*/
SELECT
	role_id
  FROM roles
 WHERE role_name = 'Instructor';

INSERT INTO users(username, email, password_hash, role_id)
VALUES
	("sses", "sses@gmail.com", "aaa11", 2);

SELECT 
	user_id
   FROM users 
 WHERE username = 'sses';
-- user_id = 10003

INSERT INTO courses(title, description, instructor_id, price)
VALUES
	("강의추가 테스트 1", "강의 추가 테스트용 1", 10003, 22222),
	("강의추가 테스트 2", "강의 추가 테스트용 2", 10003, 33333);

-- 등록 잘 됐나 나만 확인하는용
SELECT
	title
  FROM courses
 WHERE instructor_id = 10003;

UPDATE
	courses
  SET title = '수정_000'
 WHERE instructor_id = 10003;

SELECT 
	title
   FROM courses 
 WHERE instructor_id = '10003';