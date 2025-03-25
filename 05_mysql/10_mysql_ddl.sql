/*
 * ddl 개념과 역할
 * DDL(Data Definition Language)
 * DDL은 데이터베이스의 구조를 정의하는 언어이다.
 * 주요 명령어로는 create, alter, drop, truncate 등이 있으며
 * 테이블 및 데이터베이스의 스키마를 정의하고 관리하는 역할을 한다.
 * */

-- 현재 사용하는 데이터베이스의 모든 테이블을 조회한다.
SHOW tables;

/*
 * 테이블 생성
 * */
CREATE TABLE course_reviews(
	review_id int AUTO_INCREMENT PRIMARY KEY comment "리뷰 ID(고유 식별자)",
	user_id int NOT NULL comment "리뷰 작성 학생 ID(외래키)",
	course_id int NOT NULL comment "리뷰가 작성된 강좌 ID(외래키)",
	rating int NOT NULL CHECK (rating BETWEEN 1 AND 5) comment "평점 (1~5점)",
	review_text TEXT comment "리뷰 내용(선택사항)",
	create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment "작성 날짜",
	-- 내 테이블의 user_id는 참조하고 있어.users의 user_id를. delete를 하면 cascade옵션을 줄거야.
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
	FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

SELECT * FROM course_reviews;

-- 요청사항: 수강평 테이블에 수정날짜 추가해주세요~

-- 테이블 수정하기
ALTER TABLE course_reviews
ADD COLUMN updated_at TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP comment "리뷰 수정 날짜";

SELECT * FROM course_reviews;


-- 컬럼 삭제
ALTER TABLE course_reviews
DROP COLUMN review_text;


-- 제약조건 적용
ALTER TABLE course_reviews
-- chk_rating는 제약조건의 이름을 명시함
ADD CONSTRAINT chk_rating CHECK (rating BETWEEN 1 AND 10);


-- TRUNCATE table
-- 데이터베이스 엔진 완전히 초기화
-- ex) 개발과정에서 테스트하면 pk키 같은건 오토인크리먼트로 자동으로 번호가 추가됨. 삭제하고 다시 추가해도 1번부터 시작하는게 아님
-- 		그래서 테스트 끝나고 나서 데이터베이스를 완전히 깨끗하게 만들 때.
TRUNCATE TABLE course_reviews;
SELECT * FROM course_reviews;

-- drop table
DROP TABLE course_reviews;
SHOW tables;





