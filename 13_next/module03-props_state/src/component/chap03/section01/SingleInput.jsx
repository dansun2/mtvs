/*
[Controlled Component란 무엇인가?]

- Controlled Component(제어 컴포넌트)는 폼 입력 요소(input, textarea, select 등)의 값을 컴포넌트의 State로 제어하는 방식을 말한다.
- 입력 요소의 value를 컴포넌트가 직접 소유하고 관리한다.

[왜 Controlled Component를 사용할까?]
- 입력값을 프로그램적으로 제어할 수 있다.
- 입력값 검증(validation), 조건부 렌더링 등을 손쉽게 구현할 수 있다.
- 사용자의 입력 흐름을 명확히 추적할 수 있다.

[Controlled vs Uncontrolled]
- Controlled: 입력값이 State에 저장되고, 컴포넌트가 이를 직접 관리한다.
- Uncontrolled: 입력값이 DOM에 직접 저장된다. (ex: ref 사용)

*/


/*
[단일 입력값 제어하기]
- input 하나의 값을 State로 관리하는 기본적인 Controlled Component 예제이다.
- onChange 이벤트 핸들러를 사용하여 입력할 때마다 State를 업데이트한다.

[핵심 흐름]
1. useState로 입력값을 저장할 State를 생성한다.
2. input 태그에 value를 State로 연결한다.
3. onChange 이벤트에서 setState 함수를 호출하여 State를 업데이트한다.

[주의]
- State를 직접 수정하는 것이 아니라 setState 함수를 통해 변경해야 한다.
*/



'use client';

import React, { useState } from 'react';

function SingleInputControl() {

    const [name, setName] = useState(''); // 입력값을 저장할 상태

    // 입력이 변경될 때마다 호출되는 함수
    function handleChange(event) {
        console.log(event.target.value);
        setName(event.target.value); // 입력된 값을 State에 반영
    }

    return (
        <div>
            <h2>단일 입력값 제어</h2>
            <input
                type="text"
                value={name}
                onChange={handleChange}
                placeholder="이름을 입력하세요"
            />
            <p>입력한 이름: {name}</p>
        </div>
    );
}

export default SingleInputControl;