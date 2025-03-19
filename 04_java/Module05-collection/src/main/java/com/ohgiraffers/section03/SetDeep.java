package com.ohgiraffers.section03;
/*
 * 깊은 개념: HashSet의 메모리와 성능
 *
 * - 기본 구조:
 *   HashSet은 해시 테이블을 기반으로 하여 객체를 저장한다.
 *   객체의 해시코드를 사용하여 해당 요소의 저장 위치를 계산한다.
 *
 * - 해시 충돌 처리:
 *   두 개 이상의 객체가 동일한 해시코드를 가질 경우(충돌),
 *   HashSet은 체이닝 방식을 사용하여 연결 리스트로 저장한다.
 *   이로 인해 충돌된 객체들은 동일한 버킷 내에서 연결되어 관리된다.
 *
 * - 메모리 구조:
 *   HashSet은 힙 메모리에 버킷 배열을 사용하여 데이터를 저장한다.
 *   각 버킷은 연결 리스트 또는 트리 구조(충돌이 심한 경우)를 사용하여 객체를 저장한다.
 *
 * - 성능 특성:
 *   - 평균적인 경우: 검색/삽입/삭제 연산은 O(1)이다.
 *     이는 해시 함수를 통해 직접 접근하기 때문이다.
 *   - 최악의 경우: 충돌이 많이 발생하면 O(n)까지 성능이 저하될 수 있다.
 *     이 경우 모든 객체가 하나의 버킷에 저장되기 때문이다.
 *
 * - 초기 용량 및 부하율:
 *   HashSet의 초기 용량을 설정할 수 있으며, 부하율(Load Factor)을 통해
 *   리사이징 시점을 조절하게 되며, 부하율이 낮으면 충돌이 줄어들고
 *   성능이 향상될 수 있다. 예를 들어, 0.75f는 75%의 사용량에 도달했을 때
 *   리사이징이 발생한다.
 *   = 리사이징이란 현재의 배열에 크기를 늘리고 기존 요소를 복사하는 과정을 의미한다.
 *     (짐은 그대로 가지고 가면서 큰 집으로 이사하는 느낌)
 *
 * - 결론:
 *   HashSet은 빠른 데이터 접근과 유연한 객체 관리를 제공하지만,
 *   해시 충돌과 메모리 사용량에 주의해야 한다.
 *   초기 용량과 부하율을 적절히 설정하여 성능을 최적화하는 것이 중요하다.
 */

import java.util.HashSet;
import java.util.Set;

public class SetDeep {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(1);
        set.add("객체1");
        System.out.println(set.hashCode());

        // 리사이징 발생
        set.add("객체2");
        System.out.println(set.hashCode());
        /* 코드 설명 */
        // - 동일한 객체는 추가되지 않음, 해시 충돌 시 체이닝.
        // - 메모리: 힙 내 버킷 구조.
        System.out.println("HashSet: " + set);

        /* 최적화 */
        // 초기 set의 사이즈를 지정하여 리사이징이 생기지 않도록 한다.
        // 그렇다고 크기를 너무 크게 지정하는 경우 메모리 낭비가 발생하니 참고한다.
        Set<Integer> optimized = new HashSet<>(1000, 0.75f);  // 초기 용량, 부하율
        // 부하율 낮추면 충돌 감소.
    }
}