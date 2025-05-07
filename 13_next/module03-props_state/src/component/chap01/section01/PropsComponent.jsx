/*
[Props란 무엇인가?]

- Props는 "Properties"의 줄임말로, 컴포넌트 간 데이터를 전달하기 위한 객체(Object) 이다.
- 주로 부모 컴포넌트가 자식 컴포넌트로 데이터를 넘겨줄 때 사용한다.
- HTML에서는 속성(attribute)으로 데이터를 넘기듯이, React/Next.js에서는 props를 사용한다.

[Props의 핵심 특징]
1. 읽기 전용(immutable)  
   - 자식 컴포넌트는 받은 props를 변경할 수 없다.
   - 이로 인해 데이터 흐름이 명확하고 안정적이다.

2. 단방향 데이터 흐름(One-way Data Flow)  
   - 항상 부모 ➔ 자식 방향으로만 데이터가 흐른다.
   - 자식에서 부모로 직접 props를 수정하거나 전달하는 것은 불가능하다.

[왜 Props를 사용할까?]
- 컴포넌트를 재사용성 높게 설계할 수 있다.
- 상위 컴포넌트가 하위 컴포넌트의 동작을 제어할 수 있다.
- 데이터 전달이 명시적이기 때문에 유지보수가 쉬워진다.

[비유]
- Props는 '부모가 자식에게 건네주는 선물'이다.
- 자식은 선물을 받아 사용할 수 있지만, 그 선물 자체를 바꿀 수는 없다.

[주의할 점]
- props를 변경하려고 하면 React가 경고하거나, 예기치 않은 버그가 발생할 수 있다.
*/

'use client'; // Next.js App Router에서는 Client Component를 명시

import React from 'react';

// Welcome 컴포넌트는 props를 통해 name 값을 전달받아 출력한다.
function Welcome(props) {
    return <h1>Hello, {props.name}</h1>; // props 객체의 name 속성에 접근
}

// 부모 컴포넌트 역할을 하는 기본 페이지 컴포넌트
function PropsComponent() {
    return (
        <div>
            {/* Welcome 컴포넌트에 name이라는 props를 전달한다 */}
            <Welcome name="Alice" />
            <Welcome name="Bob" />
        </div>
    );
}

export default PropsComponent;