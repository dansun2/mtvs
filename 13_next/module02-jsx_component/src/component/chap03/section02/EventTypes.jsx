/*
React에서 자주 사용되는 이벤트 타입들

주요 이벤트 유형:
1. 클릭 이벤트: onClick
2. 폼 이벤트: onChange, onSubmit
3. 키보드 이벤트: onKeyDown, onKeyUp, onKeyPress
4. 마우스 이벤트: onMouseOver, onMouseOut
5. 포커스 이벤트: onFocus, onBlur

모든 이벤트는 합성 이벤트(SyntheticEvent)로 브라우저 호환성 보장
*/

import FormEvent from "./component/FormEvent";
import KeyEvent from "./component/KeyEvent";
import MouseEvent from "./component/MouseEvent";

function EventTypes() {

    return (
        <div>
            <h2>다양한 이벤트 타입</h2>

            <FormEvent />

            <hr />

            <MouseEvent />

            <hr />

            <KeyEvent />
        </div>
    );
}

export default EventTypes;


/*
'use client' 사용 가이드라인

Next.js의 App Router에서 `"use client"`는 컴포넌트를 클라이언트 컴포넌트로 지정하여 React Hooks(`useState`, `useEffect` 등)나 
이벤트 핸들러(`onClick`, `onChange` 등), 브라우저 API(`window`, `localStorage` 등)를 사용할 수 있게 한다. 
이는 클라이언트 사이드 렌더링(CSR)을 가능하게 하지만, Next.js의 서버 사이드 렌더링(SSR) 및 
서버 컴포넌트의 이점(빠른 초기 로드, SEO 최적화, 최소화된 JavaScript 번들)을 유지하려면 신중히 사용해야 한다.

핵심: 서버 컴포넌트와 클라이언트 컴포넌트의 이점을 모두 살리기
Next.js의 강점은 서버 컴포넌트와 클라이언트 컴포넌트를 조화롭게 사용하여 성능과 사용자 경험을 극대화하는 데 있다. 
`"use client"`를 효과적으로 사용하면 다음과 같은 두 가지 이점을 모두 누릴 수 있다:

1. 서버 컴포넌트의 이점:
   - 서버에서 HTML을 미리 렌더링하여 초기 페이지 로드 속도 향상.
   - 검색 엔진 최적화(SEO) 및 소셜 미디어 공유 시 정적 콘텐츠 제공.
   - 클라이언트로 전송되는 JavaScript 양을 최소화하여 성능 최적화.
   - 서버에서 데이터 페칭 및 무거운 연산 처리로 클라이언트 부담 감소.

2. 클라이언트 컴포넌트의 이점:
   - React Hooks를 활용한 동적 상태 관리 및 인터랙티브 UI 구현.
   - 사용자 입력, 애니메이션, 실시간 업데이트 등 풍부한 사용자 경험 제공.
   - 서드파티 라이브러리(예: Framer Motion, React-Query)와의 호환성.

즉, 현재 작성한 방식과 같이 실제 클라이언트 측에서 돌아야 하는 컴포넌트에 use Client를 사용하고
그렇지 않는 컴포넌트는 SSR 방식으로 적용하여 랜더링 효율을 늘린다.   
*/