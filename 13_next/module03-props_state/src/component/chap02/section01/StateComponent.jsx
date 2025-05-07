/*
[State 변경의 비동기성 설명]

- React에서는 setState나 setCount와 같은 상태 업데이트 함수가 **비동기적으로 작동**할 수 있다.
- 즉, setState를 호출했다고 해서 즉시 상태값이 변경되지는 않는다.

[왜 비동기적으로 동작할까?]
- 여러 상태 업데이트를 하나로 모아서 처리하여 성능을 최적화하기 위해서이다.
- 이는 "Batching"이라고 불리는 기법으로, 렌더링 횟수를 줄이고 효율을 높인다.

[예시로 알아보기]
- setCount를 호출한 직후 console.log(count)를 찍으면 여전히 이전 값이 출력된다.
- 실제로 변경된 값은 다음 렌더링 사이클에 반영된다.

[주의사항]
- 상태값을 기준으로 다음 상태를 계산할 때는 항상 "업데이트 함수"를 활용하는 것이 안전하다.
*/


// <실습 코드>

'use client';

import { useState } from 'react';

function StateComponent() {

  const [count, setCount] = useState(0); // 프록시?뭔말인지 모르겠음..useState는 컴포넌트가 갖는 상태

  function handleClick() {
    setCount(count + 1); // 상태 업데이트 요청
  }

  return (
    <div>
      <h2>State 비동기성 이해하기</h2>
      <p>현재 카운트: {count}</p>
      <button onClick={handleClick}>
        클릭
      </button>
    </div>
  );
}

export default StateComponent;