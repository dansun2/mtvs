function JSXIntro() {

    const name = "홍길동";
    return (
        <>
            <h1>jsx 개념과 역할</h1>
            <div>
                <h2>안녕하세요!</h2>
                <p>{name}님 환영합니다.</p>
                <p>현재 시간 : {new Date().toLocaleTimeString()}</p>
            </div>

            <div>
                <h2>JSX 변환 과정</h2>
                <p>
                    위 JSX 코드는 react.createElement() 함수 호출로 변환된다.
                    바벨(babel)이 변환 작업을 처리한다.
                </p>
            </div>

            <div>
                <h2>Virtual Dom과 관계</h2>
                <p>
                    jsx로 작성된 코드는 react 요소로 변환되고,
                    이 요소들이 Virtual Dom을 구성하게 된다.
                    react는 상태 변경 시 Virtual Dom을 효율적으로 업데이트한다.
                </p>
                <img src="https://velog.velcdn.com/images/ksykma/post/824b6071-2888-4613-84b8-1a272a09224c/image.png" width={"600px"} height={"300px"}/>
            
            </div>
        </>
    );
}

export default JSXIntro;