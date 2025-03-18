<요구사항 명세화>  
**미션 1: 도서 할인 가격 계산 기능 구현 (인터페이스 및 제네릭 활용)**
- **입력:**
    - Discountable 인터페이스를 구현한 도서 객체 배열
        - PrintedBook와 Ebook 클래스 (각각 할인 정책이 다름)
- **처리:**
    1. **인터페이스 정의:**
        - `Discountable` 인터페이스를 정의하고, 추상 메서드 `double getDiscountedPrice()`를 선언한다.
    2. **Book 추상 클래스 정의:**
        - `Book` 클래스는 private 멤버 변수 `title`, `author`, `price`를 갖고, 생성자와 getter 메서드를 제공한다.
    3. **클래스 구현:**
        - `PrintedBook` 클래스는 `Book`을 상속받고 `Discountable`을 구현한다.
            - 할인 정책: 예를 들어, 일정 배송비 할인 없이 기본 가격에 소폭 할인을 적용 (예: 5% 할인).
        - `Ebook` 클래스는 `Book`을 상속받고 `Discountable`을 구현한다.
            - 할인 정책: `price - (price * discountRate)` 방식으로 할인 가격을 산출한다.
    4. **제네릭 계산 클래스:**
        - `BookDiscountCalculator` 클래스 내에 제네릭 메서드 `calcDiscountedPrices(T[] items)` (단, T는 Discountable을 구현)
            - 배열을 순회하며 각 도서의 할인 가격을 합산하고 평균을 계산한 후,
            - 결과 문자열을 "총 할인 가격: X, 평균 할인 가격: Y" 형태로 반환한다.
- **포함 기술:** 변수, 데이터 타입, 연산자, 배열과 문자열 다루기, 클래스 및 객체, 생성자, 캡슐화, 상속, 다형성, 인터페이스, 제네릭스
- **JUnit 활용:** @BeforeEach, @AfterEach, @Test, assertEquals, assertTrue (인터페이스 구현체 테스트 포함)

<개발 순서>
1. `Discountable` 인터페이스 정의: `double getDiscountedPrice()`
2. 추상 클래스 `Book` 정의: private 멤버 변수( title, author, price ), 생성자, getter
3. `PrintedBook` 클래스 정의: Book 상속, Discountable 구현, 추가 할인율 멤버 변수 (예: 0.05) 및 오버라이딩
4. `Ebook` 클래스 정의: Book 상속, Discountable 구현, discountRate 멤버 변수 및 오버라이딩
5. `BookDiscountCalculator` 클래스 내에 제네릭 메서드로 총 할인 가격과 평균 할인 가격을 계산하여 결과 문자열 반환
6. main() 메서드로 테스트 데이터 실행 및 결과 출력