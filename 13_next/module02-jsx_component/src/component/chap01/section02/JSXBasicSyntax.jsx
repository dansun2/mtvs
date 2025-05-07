/**
 * JSX 문법의 기초
 * jsx는 javascript내에서 html과 유사한 마크업을 작성할 수 있도록 해주는 문법이다.
 * 가장 기본적인 jsx 문법 요소는 다음과 같다.
 * 
 * 1. 중괄호 표현식 : JavaScript 변수나 표현식을 jsx내에 삽입할 때 사용
 * 2. 속성 바인딩 : html 속성을 jsx에서 사용할 때의 규칙
 * 3. 조건부 렌더링 : 조건에 따라 다른 Ui를 표시하는 방법
 */

function JSXBasicSyntax() {
    const name = "홍길동";
    const age = 30;
    const isAdmin = true;

    const birthYear = new Date().getFullYear() - age;

    const user = {
        name : "김철수",
        job : "개발자",
        address : "서울시 강남구"
    };

    const products = [
        { id : 1, name : "노트북", price : 12000 },
        { id : 2, name : "스마트폰", price : 9000 },
        { id : 3, name : "태블릿", price : 655000 },
    ];

    const style = {
        color: isAdmin ? 'blue' : 'black',
        fontWeight: 'bold',
        fontSize: '16px'
    };

    return (
        <div>
            <h1>JSX 문법의 기초</h1>
            {/**
             * 1. 중괄호 표현식
             * jsx에서는 중괄호{}를 사용하여 JavaScript 표현식을 삽입할 수 있다.
             * 예를 들어, 변수, 연산, 함수 호출 등의 결과를 jsx 내부에 동적으로 표시할 수 있다.
             */}
             <div>
                <h2>중괄호 표현식</h2>
                <p>안녕하세요. {name}</p>

                <p>나이 : {age}세</p>
                <p>출생년도 : {birthYear}</p>
                <p>관리자 여부 : {isAdmin ? "관리자" : "일반사용자"}</p>

                <p>사용자 직업 : {user.job}</p>
                <p>사용자 주소 : {user.address}</p>
                <p>2+3 = {2+3}</p>
                <p>age * 2 = {age*2}</p>
             </div>

             {/* 
            2. 속성 바인딩
            JSX에서는 HTML의 class 속성 대신 className을 사용한다.
            그 이유는 JSX가 JavaScript의 확장 문법이기 때문이다.
            JSX 코드는 실제로 JavaScript 코드로 변환되며,
            이 과정에서 HTML 속성명이 JavaScript의 표기법(camelCase)으로 바뀐다.

            또한, class는 JavaScript의 예약어이기 때문에 충돌을 피하기 위해 className을 사용한다.
            이처럼 HTML의 속성명과 달리 JSX에서는 일부 속성을 다르게 정의한다.
            예) background-color → backgroundColor
            예) class → className
            예) font-size → fontSize

            */}
            <div>
                <h2>속성 바인딩</h2>

                {/* className 사용 (HTML의 class 대신) */}
                <div className="user-info">
                    <p>className은 HTML class 속성을 대체합니다.</p>
                </div>

                {/* 동적 속성 바인딩 */}
                <input
                    type="text"
                    placeholder={`${name}님의 정보를 입력하세요`}
                    disabled={isAdmin}
                />

                {/* 
                인라인 스타일(JSX의 style 속성)
                JSX에서는 style 속성에 하나의 자바스크립트 객체(JSON 형태)를 전달하여 여러 CSS 스타일을 한 번에 적용할 수 있다.
                이 객체는 여러 스타일 속성을 key-value 쌍으로 포함하며, 각 속성명은 camelCase(예: backgroundColor, fontSize)로 작성한다.

                즉, 여러 개의 CSS 속성을 하나의 객체로 묶어서 style에 전달하면, 해당 객체의 모든 스타일이 한 번에 적용된다.
                이 방식은 기존 HTML의 style="..."과 달리, 자바스크립트 코드에서 동적으로 스타일 값을 조합하거나 변수로 관리할 때 매우 유용하다.

                */}
                <p style={style}>
                    스타일은 객체 형태로 지정합니다.
                </p>
            </div>

            {/* 
            3. 배열과 리스트 렌더링
            JSX에서는 배열의 map() 함수를 사용하여 여러 요소를 반복 렌더링할 수 있다.
            각 항목을 렌더링할 때는 고유한 key 속성을 지정해야 하며, 이를 통해 React가 각 요소를 효율적으로 관리할 수 있게 된다.
            key는 각 요소를 고유하게 식별하는 값으로, 가상 DOM에서 요소를 식별하고 최적화하는데 사용된다.

            예) products.map(product => (<li key={product.id}>{product.name}</li>))
            */}
            <div>
                <h2>배열과 리스트 렌더링</h2>
                <ul>
                    {
                    products.map(product => (
                        <li key={product.id}>
                            {product.name} : {product.price.toLocaleString()}원
                        </li>
                    ))
                    }
                </ul>
            </div>
        </div>
    )
}

export default JSXBasicSyntax;