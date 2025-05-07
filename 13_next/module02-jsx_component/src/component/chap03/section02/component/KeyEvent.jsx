"use client";

function KeyEvent() {
    // 키보드 이벤트 핸들러
    const handleKeyDown = (e) => {
        console.log('눌린 키:', e.key);
        if (e.key === 'Enter') {
            alert('Enter 키를 누르셨습니다!');
        }
    };

    return (
        <>
            {/* 키보드 이벤트 (onKeyDown) */}
            <div>
                <h3>키보드 이벤트 (onKeyDown)</h3>
                <input
                    type="text"
                    onKeyDown={handleKeyDown}
                    placeholder="Enter 키를 눌러보세요"
                />
            </div>
        </>
    );

}

export default KeyEvent;