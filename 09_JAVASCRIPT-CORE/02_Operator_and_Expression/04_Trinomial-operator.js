/*
삼항 연산자 실습
특정 학생의 점수와 나이에 따라 조건을 처리한다.
조건문과 삼항 연산자를 비교하여 사용한다.
*/

// 1. 문제 상황
// 학생 관리 시스템에서 특정 학생의 점수에 따라 합격 여부를 출력한다.
// 점수가 60점 이상이면 합격, 그렇지 않으면 불합격으로 처리한다.

let studentName = "김철수";
let studentScore = 85;

// 조건문으로 처리
let result;
if (studentScore >= 60) {
    result = "합격";
} else {
    result = "불합격";
}
console.log(`${studentName}의 시험 결과:`, result); // 출력: 김철수의 시험 결과: 합격

// 삼항 연산자로 처리
result = studentScore >= 60 ? "합격" : "불합격";
console.log(`${studentName}의 시험 결과:`, result); // 출력: 김철수의 시험 결과: 합격

/*
장점:
삼항 연산자는 조건문보다 간결하게 작성할 수 있다.
단일 조건 처리에 적합하다.
*/

// 2. 성인 여부 판별
// 학생의 나이가 18세 이상이면 "성인", 그렇지 않으면 "미성년자"로 출력한다.

let studentAge = 16;

// 조건문으로 처리
let ageCategory;
if (studentAge >= 18) {
    ageCategory = "성인";
} else {
    ageCategory = "미성년자";
}
console.log(`${studentName}의 나이: ${studentAge}, 분류: ${ageCategory}`); // 출력: 김철수의 나이: 16, 분류: 미성년자

// 삼항 연산자로 처리
ageCategory = studentAge >= 18 ? "성인" : "미성년자";
console.log(`${studentName}의 나이: ${studentAge}, 분류: ${ageCategory}`); // 출력: 김철수의 나이: 16, 분류: 미성년자

/*
삼항 연산자는 간단한 조건 처리에는 유용하지만, 복잡한 조건이 필요한 경우에는 오히려 가독성을 해칠 수 있다.
*/

// 3. 다중 조건 처리
// 학생 점수에 따라 등급을 매긴다.
// 90점 이상: "A", 80점 이상: "B", 70점 이상: "C", 그 외: "F".

let grade;
if (studentScore >= 90) {
    grade = "A";
} else if (studentScore >= 80) {
    grade = "B";
} else if (studentScore >= 70) {
    grade = "C";
} else {
    grade = "F";
}
console.log(`${studentName}의 성적 등급:`, grade); // 출력: 김철수의 성적 등급: B

// 삼항 연산자로 처리
grade = studentScore >= 90 ? "A" :
        studentScore >= 80 ? "B" :
        studentScore >= 70 ? "C" : "F";
console.log(`${studentName}의 성적 등급:`, grade); // 출력: 김철수의 성적 등급: B

/*
다중 조건 처리에서는 삼항 연산자가 코드의 가독성을 떨어뜨릴 수 있다.
조건이 복잡할수록 일반적인 조건문 사용이 적합하다.
*/