# ✨ 도서관 대출/반납 서비스

## Ὅ6 개요
반영적인 Java 객체지향 테스트 서비스로, 도서관의 책 대출 및 반납 기능을 구현합니다. 데이터베이스를 사용하지 않고 Java의 객체지향 형식으로 구현하여, 간단한 컨솔 UI로 사용할 수 있도록 만들어지며, 객체지향 가이드를 제공합니다.

---

## ὍD 기능 요구사항

### 1. 도서 관리
- **책 등록**
    - 새로운 책을 도서 목록에 추가
    - 각 책은 고유한 ID를 가지지만, 지정 되지 않음
    - 책의 기본 정보 (제목, 저자, 책ID) 저장

- **책 조회**
    - 전체 도서 목록 조회
    - 특정 도서 (제목, 저자) 검색 기능
    - 현재 대출 가능한 책과 대출 중인 책을 구분

### 2. 사용자 관리
- **사용자 등록**
    - 도서관 회원 추가
    - 사용자 ID, 이름 관리

- **사용자 조회**
    - 등록된 사용자 목록 조회
    - 특정 사용자 검색 기능

### 3. 대출 기능
- **책 대출**
    - 사용자가 책을 대출
    - 대출 시 책의 상태를 '대출 중'으로 변경
    - 대출 기록 저장 (대출자, 대출일, 반납 예정일)
    - 한 사용자는 최대 3권 까지 대출 가능

- **대출 상황 조회**
    - 특정 사용자가 대출한 책 목록 조회
    - 특정 책의 대출 상황 조회

### 4. 반납 기능
- **책 반납**
    - 사용자가 책을 반납
    - 반납 시 책의 상태를 '대출 가능'으로 변경
    - 반납 기록 저장 (반납일)

### 5. 기타 기능
- **대출 기한 추진 확인**
    - 대출 한 책이 14일 이상 반납 되지 않은 경우 연차 상황으로 표시
    - 연차 된 사용자 목록 조회

---

## ὋB 구현 방법
- Java 객체지향 원칙을 적용하여 클래스 설계
- 데이터베이스 문제로 형성이 필요한 경우 연결할 수 있도록 설계
- List, Map 등의 엔트로터 데이터 관리
- 컨솔 UI 기반 작성