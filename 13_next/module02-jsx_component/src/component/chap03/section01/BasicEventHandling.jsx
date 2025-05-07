// component/chap03/section01/BasicEventHandling.jsx
/*
JSX에서의 이벤트 핸들링 기본 개념

React와 일반 HTML의 이벤트 처리 방식 차이점:
1. 이벤트 이름은 camelCase로 작성 (HTML: onclick, React: onClick)
2. 이벤트 핸들러는 함수 참조로 전달 (문자열 X)
3. 기본 동작 방지를 위해 preventDefault()를 명시적으로 호출. 이걸 막아주지 않으면 화면에 입력한 값이 반영안된다. 혹은 재귀호출이 일어남남 <- form 태그 쓸 때 많이 씀 

기본 문법: <요소 이벤트명={핸들러함수}>
*/

"use client"; // 클라이언트 컴포넌트 선언 (이벤트 핸들러 사용 시 필수)

function BasicEventHandling() {
    // 이벤트 핸들러 함수 정의
    const handleClick = () => {
        console.log('버튼이 클릭되었습니다!');
        alert('버튼 클릭!');
    };

    return (
        <div>
            <h2>기본 이벤트 핸들링</h2>

            {/* 기본 클릭 이벤트 */}
            <button onClick={handleClick}>클릭</button>

            {/* HTML과 React 이벤트 비교 */}
            <div style={{ marginTop: '20px' }}>
                <h3>HTML vs React 이벤트 처리 비교</h3>
                <pre>
                    {`<!-- HTML 방식 -->
                    <button onclick="handleClick()">클릭</button> 이렇게 하면 함수를 호출해서 실행된 값만 전달이 됨

                    {/* React 방식 */}
                    <button onClick={handleClick}>클릭</button>`}
                </pre>
            </div>

            {/* 잘못된 이벤트 핸들링 예시 */}
            <div style={{ marginTop: '20px' }}>
                <h3>잘못된 이벤트 핸들링 예시</h3>
                <pre>
                    {`// 잘못된 방식 (함수 호출 결과를 전달)
                    <button onClick={handleClick()}>잘못된 방식</button>

                    // 올바른 방식 (함수 참조를 전달)
                    <button onClick={handleClick}>올바른 방식</button>`}
                </pre>
                <p>잘못된 방식에서는 렌더링 시점에 함수가 즉시 실행되며, 이벤트 핸들러로 undefined가 할당된다.</p>
            </div>
        </div>
    );
}


export default BasicEventHandling;


/*
"use client"란 무엇인가?
"use client"는 Next.js의 App Router에서 특정 컴포넌트를 클라이언트 컴포넌트로 지정하는 지시문이다. 
이 지시문은 파일 최상단에 작성되며, 해당 컴포넌트와 그 하위 컴포넌트가 클라이언트 사이드에서 실행되도록 브라우저에 전달한다.
Next.js의 App Router에서는 기본적으로 모든 컴포넌트가서버 컴포넌트(Server Component)로 간주되며 서버 컴포넌트는 서버에서 렌더링되고, 
클라이언트로 전송되는 HTML은 최소한의 JavaScript만 포함하게 된다. 
하지만 클라이언트에서만 동작해야 하는 특정 기능(예: 상태 관리, 이벤트 핸들러, 브라우저 API 사용 등)이 필요한 경우, 
"use client"를 사용하여 해당 컴포넌트를 클라이언트 컴포넌트로 전환한다.


2. "use client"를 사용하는 주요 이유
"use client"를 사용하는 이유는 Next.js의 서버 중심 아키텍처와 클라이언트 중심 기능의 조화를 이루기 위함이다. 

2-1) 필요 상황
(1) 클라이언트 전용 기능 사용
React와 Next.js에서 클라이언트에서만 동작하는 기능들이 있다. 
이러한 기능들은 서버 환경에서 실행할 수 없으므로, "use client"를 통해 클라이언트에서 실행되도록 지정해야 한다. 

예를 들어:
React Hooks: useState, useEffect, useContext 등은 클라이언트에서만 동작한다. 
서버 컴포넌트에서는 이러한 훅을 사용할 수 없다.

브라우저 API: window, document, localStorage, navigator 등 브라우저 환경에서만 접근 가능한 API는 서버에서 실행할 수 없다.

이벤트 핸들러: onClick, onChange 등 사용자 인터랙션을 처리하는 이벤트 핸들러는 클라이언트에서 실행되어야 한다
*/