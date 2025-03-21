-- 기존 데이터베이스 삭제 (있다면)
DROP DATABASE IF EXISTS HELLOWORLDLABS_LMS;

-- 새로운 데이터베이스 생성
CREATE DATABASE HELLOWORLDLABS_LMS;

-- SQL 계정 생성.
-- @'호스트' <- 해당 호스트에 포함하지 않은 대상은 접속이 제한된다.
-- localhost : 나의 로컬 환경에서만 가능
-- % : 모든 원격에서 접속가능
-- 특정 ip : 해당 ip 및 local에서 접속가능
-- 'gorilla' 까지가 내 계정이 아니고 'gorilla'@'%' 까지가 내 계정
create user 'hyun'@'%' IDENTIFIED BY 'hyun';


-- 계정 권한 부여
-- GRANT 권한을 부여하기 위한 명령문이다.
-- ALL PRIVILEGES 'root'계정과 비슷한 수준의 권한을 준다. 근데 계정 생성같은건 불가능함
-- GRANT 권한목록 ON 데이터베이스.테이블 TO '사용자명'@'호스트';
-- 데이터베이스.*에서 *은 모든 테이블을 의미한다.
GRANT ALL PRIVILEGES ON HELLOWORLDLABS_LMS.* TO 'hyun'@'%';


-- HELLOWORLDLABS_LMS 사용 -> root 계정은 모든 DB에 접근할 수 있는데
USE HELLOWORLDLABS_LMS;

-- SHOW TABLES: 현재 테이블 목록 확인.
SHOW TABLES;