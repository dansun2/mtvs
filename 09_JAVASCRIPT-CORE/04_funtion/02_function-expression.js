/*
# 문법 설명
1. 함수 표현식은 함수를 변수에 저장해 재사용성을 높인다.
2. 화살표 함수는 간결한 문법으로 작성되며, `this`의 동작 방식이 고정된다.
3. 반환값이 한 줄로 작성 가능할 경우, 중괄호와 `return`을 생략할 수 있다.
*/

// 스토리: 쇼핑몰의 할인 계산 시스템
// 사용자가 구매 금액과 회원 등급을 입력하면, 할인 금액과 최종 결제 금액을 계산하는 프로그램.

/*
# 실습 코드
*/

/*
# 1. 함수 표현식으로 할인 계산
회원 등급에 따라 할인율을 계산하는 함수 작성.
*/
const calculateDiscount = function(amount, level) {
    if (level === "VIP") {
        return amount * 0.2; // VIP는 20% 할인
    } else if (level === "Gold") {
        return amount * 0.15; // Gold는 15% 할인
    } else {
        return amount * 0.1; // 기본 할인율은 10%
    }
};

let discount = calculateDiscount(100000, "VIP");
console.log(`VIP 회원의 할인 금액: ${discount}`); // 출력: 20000

discount = calculateDiscount(100000, "Gold");
console.log(`Gold 회원의 할인 금액: ${discount}`); // 출력: 15000

/*
결과 설명
- 함수 표현식 `calculateDiscount`는 회원 등급과 금액을 입력받아 할인 금액을 반환.
- 조건에 따라 할인율이 다르게 적용.
*/

/*
# 2. 화살표 함수로 최종 금액 계산
할인 금액을 차감한 최종 결제 금액을 계산하는 함수 작성.
*/
const calculateFinalAmount = (amount, discount) => amount - discount;

let finalAmount = calculateFinalAmount(100000, 20000);
console.log(`VIP 회원의 최종 결제 금액: ${finalAmount}`); // 출력: 80000

finalAmount = calculateFinalAmount(100000, 15000);
console.log(`Gold 회원의 최종 결제 금액: ${finalAmount}`); // 출력: 85000

/*
결과 설명
- 화살표 함수 `calculateFinalAmount`는 간결한 문법으로 최종 금액을 계산.
- 단일 반환문을 활용해 중괄호와 `return` 생략.
*/

/*
# 3. `this` 바인딩의 차이
객체 내 일반 함수와 화살표 함수의 `this` 동작 비교.
*/
const customer = {
    name: "홍길동",
    level: "VIP",
    getLevel: function() {
        console.log(`일반 함수: ${this.level}`);
    },
    getLevelArrow: () => {
        console.log(`화살표 함수: ${this.level}`);
    }
};

customer.getLevel(); // 출력: VIP
customer.getLevelArrow(); // 출력: undefined (화살표 함수는 `this`를 고정)

/*
결과 설명
- 일반 함수는 호출 위치에 따라 `this`가 동적으로 설정.
- 화살표 함수는 선언 당시의 `this`를 고정.
*/

/*
# 4. 함수와 배열 결합
구매 내역 배열에서 총 결제 금액 계산.
*/
const purchases = [    { amount: 50000, level: "VIP" },    { amount: 30000, level: "Gold" },    { amount: 20000, level: "Basic" }];

const totalAmount = purchases.reduce((total, purchase) => {
    const discount = calculateDiscount(purchase.amount, purchase.level);
    const finalAmount = calculateFinalAmount(purchase.amount, discount);
    return total + finalAmount;
}, 0);

console.log(`총 결제 금액: ${totalAmount}`);

/*
결과 설명
- 배열의 `reduce` 메서드와 화살표 함수를 결합해 총 금액 계산.
- 각 구매 항목별 할인 적용 후 결제 금액을 합산.
*/

/*
결론:
1. 함수 표현식은 변수로 선언해 재사용성을 높인다.
2. 화살표 함수는 간결한 문법과 고정된 `this` 바인딩을 제공.
3. 배열과 결합한 고차 함수 활용으로 로직 간소화 가능.
*/



/*
일급 객체
일급 객체(First-Class Object)는 프로그래밍 언어에서 객체가 가지는 특성을 나타내는 용어로,

다음과 같은 특징을 갖고 있다:

일급 객체의 특징
- 변수에 할당 가능: 일급 객체는 변수에 할당할 수 있다. 
즉, 함수나 다른 객체와 마찬가지로 변수에 저장할 수 있다.

- 함수의 인수로 전달 가능: 일급 객체는 다른 함수의 인수로 전달할 수 있다.
이를 통해 고차 함수를 구현할 수 있다.
*고차 함수 : 다른 함수를 인수로 받거나 함수를 반환하는 함수. 

- 함수의 반환값으로 사용 가능: 일급 객체는 함수의 반환값으로 사용할 수 있다. 
함수를 호출한 결과로 다른 함수를 반환할 수 있다.

- 동적으로 생성 가능: 일급 객체는 프로그램 실행 중에 동적으로 생성할 수 있다. 
즉, 런타임에 새로운 객체를 만들 수 있다.
*/