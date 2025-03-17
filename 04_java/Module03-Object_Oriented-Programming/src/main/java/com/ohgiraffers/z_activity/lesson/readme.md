## <요구사항 명세화>
### 미션 1: 도서 재고 및 가격 집계 기능 구현 (객체지향 적용)
- 입력: Book 객체 배열 (각 Book은 도서 정보와 기본 가격 정보를 포함하며, 도서 종류에 따라 최종 가격 계산 방식이 다름)
- 처리:
  - 추상 클래스 Book을 정의하여 private 멤버 변수 title, author, basePrice를 선언하고, 생성자와 getter, 그리고 추상 메서드 getFinalPrice()를 제공한다.
  - PrintedBook 클래스는 Book을 상속받아 shippingCost 멤버 변수를 추가하고, getFinalPrice()를 오버라이딩하여 (basePrice + shippingCost)를 반환한다.
  - Ebook 클래스는 Book을 상속받아 discountRate 멤버 변수를 추가하고, getFinalPrice()를 오버라이딩하여 (basePrice - (basePrice * discountRate))를 반환한다.
  - BookInventoryCalculator 클래스는 Book 배열을 받아 다형성을 활용하여 각 도서의 최종 가격을 계산,
    - 총 재고 가치, 평균 가격, 최고가 도서 및 최저가 도서를 산출하고,
    - "총 재고 가치: X, 평균 가격: Y, 최고가 도서: [Title], 최저가 도서: [Title]" 형태의 결과 문자열로 반환한다.
- 포함 기술: 변수, 데이터 타입, 연산자, 배열과 문자열 다루기, 클래스 및 객체, 생성자, 캡슐화, 상속, 다형성
- JUnit 활용: @BeforeEach, @AfterEach, @Test, assertEquals, assertTrue

<개발 순서>
1. 추상 클래스 Book을 정의하여 private 멤버 변수, 생성자, getter 및 추상 메서드 getFinalPrice()를 구현
2. PrintedBook 클래스를 정의하여 Book을 상속받고, shippingCost를 추가하며 getFinalPrice()를 오버라이딩
3. Ebook 클래스를 정의하여 Book을 상속받고, discountRate를 추가하며 getFinalPrice()를 오버라이딩
4. BookInventoryCalculator 클래스를 정의하여 Book 배열을 처리하고, for문을 통해 총 가치, 평균, 최고/최저 가격 도서를 계산하는 메서드 구현
5. 결과 문자열을 생성하여 반환