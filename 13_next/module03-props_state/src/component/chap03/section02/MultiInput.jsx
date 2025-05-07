/*
[여러 입력값 제어하기]

- 여러 개의 입력 필드를 관리할 때 각각의 useState를 만들 수도 있지만,
- 객체 형태의 State를 사용하면 훨씬 효율적이다.

[핵심 흐름]
1. 객체 형태로 여러 입력 필드 값을 관리한다.
2. input 요소의 name 속성을 활용하여 어떤 필드를 변경할지 식별한다.
3. setState 함수 안에서 spread 문법(...)을 사용하여 나머지 값을 유지하면서 특정 필드만 변경한다.

[비유]
- 여러 개의 방이 있는 호텔에서, 특정 방만 키를 열고 수리하는 느낌.

리덕스에 덕스패턴? 여기서 많이 씀
*/



'use client';

import React, { useState } from 'react';

export default function MultiInputControl() {

  const [formData, setFormData] = useState({
    firstName: '',
    lastName: ''
  });

  // 입력값이 변경될 때 호출되는 함수
  function handleChange(event) {
    const { name, value } = event.target;
    setFormData({
      ...formData,          // 기존의 나머지 값은 유지하고
      [name]: value         // name에 해당하는 값만 수정
    });
  }

  return (
    <div>
      <h2>다중 입력값 제어</h2>
      <input 
        type="text" 
        name="firstName"
        value={formData.firstName}
        onChange={handleChange}
        placeholder="이름(First Name)" 
      />
      <input 
        type="text" 
        name="lastName"
        value={formData.lastName}
        onChange={handleChange}
        placeholder="성(Last Name)" 
      />
      <p>입력한 이름: {formData.firstName} {formData.lastName}</p>
    </div>
  );
}