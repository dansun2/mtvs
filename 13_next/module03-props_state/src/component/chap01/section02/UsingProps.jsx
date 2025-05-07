/*
[Props 사용법과 전달 방법]

- 부모 컴포넌트는 자식 컴포넌트를 사용할 때 props를 전달할 수 있다.
- 전달 방식은 HTML 속성을 넘기는 방식과 유사하다.
- props는 여러 개를 동시에 전달할 수 있으며, 각각은 객체의 속성(key-value) 형태로 접근한다.

[구조 분해(Destructuring) 사용]
- props 객체를 매개변수에서 직접 구조 분해할 수 있다.
- 코드 가독성이 향상되고, props.name 대신 name처럼 간결하게 사용할 수 있다.

[Props를 전달할 때 주의사항]
- 반드시 올바른 props 이름으로 전달해야 한다.
- 구조 분해를 사용할 때는 props 이름이 정확히 일치해야 한다.
*/


'use client';

import React from 'react';

// 구조 분해를 사용하지 않고 props 객체를 직접 사용하는 경우
function Greeting(props) {
    return (
        <div>
            <p>안녕하세요, {props.name}님!</p>
            <p>오늘은 {props.day}입니다.</p>
        </div>
    );
}

// 구조 분해(destructuring)를 사용하는 경우
function GreetingDestructured({ name, day }) {
    return (
        <div>
            <p>안녕하세요, {name}님!</p>
            <p>오늘은 {day}입니다.</p>
        </div>
    );
}

// 부모 컴포넌트
export default function UsingProps() {
    return (
        <div>
            {/* 여러 개의 props를 전달한다 */}
            <Greeting name="Charlie" day="수요일" />
            <GreetingDestructured name="Diana" day="목요일" />
        </div>
    );
}