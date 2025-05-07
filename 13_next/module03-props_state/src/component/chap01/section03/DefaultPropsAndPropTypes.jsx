/*
[Props 기본값 설정 (defaultProps)]
- props가 부모로부터 전달되지 않았을 때 사용할 기본값을 설정할 수 있다.

*/

'use client';

import React from 'react';

// UserProfile 컴포넌트: 이름(name)과 나이(age)를 받아서 출력
function UserProfile({ name, age=20 }) {

    return (
        <div>
            <h2>사용자 프로필</h2>
            <p>이름: {name}</p>
            <p>나이: {age}세</p>
        </div>
    );
}


// 부모 컴포넌트
function DefaultPropsAndPropTypes() {
    return (
        <div>
            {/* name만 전달하고 age는 생략함 → 기본값 20이 적용된다 */}
            <UserProfile name="Eve" />

            {/* name과 age 모두 명시적으로 전달 */}
            <UserProfile name="Frank" age={30} />
        </div>
    );
}

export default DefaultPropsAndPropTypes;