/*
[부모의 상태를 자식 컴포넌트에서 변경하기]

- 일반적으로 State는 컴포넌트 내부에서 관리된다.
- 그러나 때로는 자식 컴포넌트가 부모 컴포넌트의 상태를 변경해야 할 필요가 있다.
  (예: 모달 닫기 버튼, 입력값 초기화 등)

[방법]
- 부모 컴포넌트가 자신의 상태를 업데이트하는 setState 함수를 props를 통해 자식 컴포넌트에 넘긴다.
- 자식 컴포넌트는 전달받은 함수를 호출하여 부모의 상태를 변경할 수 있다.

[핵심 개념]
- 자식은 부모의 상태 자체를 알지 못한다.
- 단지 "부모가 준 함수"를 호출할 뿐이다.
- 따라서 여전히 **단방향 데이터 흐름(one-way data flow)** 이 유지된다.

[비유]
- 부모가 '리모컨 버튼'을 자식에게 준 것과 같다.
- 자식은 리모컨 버튼을 누를 수 있지만, 리모컨 속 기계(상태)를 직접 고칠 수는 없다.
*/


// <실습 코드>

'use client';

import React, { useState } from 'react';

// 자식 컴포넌트: 부모로부터 받은 setCount 함수를 사용
function ChildButton({ increaseCount }) {
  return (
    <button onClick={increaseCount}>
      자식 컴포넌트에서 카운트 증가
    </button>
  );
}

// 부모 컴포넌트
function ChildUpdateParentState() {

  const [count, setCount] = useState(0); // 부모가 관리하는 상태

  // 부모 내부에서 상태를 변경하는  함수
  function handleIncrease() {
    setCount(prev => prev + 1); // 함수형 업데이트 사용 (권장 방식)
  }

  return (
    <div>
      <h2>부모-자식 상태 제어 예제</h2>
      <p>현재 카운트: {count}</p>

      {/* 자식에게 상태 변경 함수를 props로 전달 */}
      <ChildButton increaseCount={handleIncrease} />
    </div>
  );
}

export default ChildUpdateParentState;