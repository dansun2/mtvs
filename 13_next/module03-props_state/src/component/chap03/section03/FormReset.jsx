/*
[입력값 초기화 및 리셋]

- 입력이 완료된 후 입력 필드를 초기화해야 할 때가 있다.
- setState를 통해 입력값을 다시 초기 상태로 되돌린다.

[핵심 흐름]
1. 초기값 상태를 기억한다.
2. 버튼 클릭 시 State를 초기값으로 리셋한다.

[주의]
- reset 로직은 form 전체 초기화 또는 특정 입력 초기화에 활용할 수 있다.
*/


// <실습 코드>

'use client';

import React, { useState } from 'react';

function FormReset() {

    const [name, setName] = useState('');

    function handleChange(event) {
        setName(event.target.value);
    }

    function handleReset() {
        setName(''); // 초기화 ex.주문을 완료하고 결제까지 했으면 내역이 사라져야됨 데이터가 남아있으면 다음사람이 써야하는데 문제됨
    }

    return (
        <div>
            <h2>입력값 초기화</h2>
            <input
                type="text"
                value={name}
                onChange={handleChange}
                placeholder="이름을 입력하세요"
            />
            <p>입력한 이름: {name}</p>
            <button onClick={handleReset}>
                입력 초기화
            </button>
        </div>
    );
}

export default FormReset;