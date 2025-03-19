package com.ohgiraffers.section01;

import java.util.ArrayList;
import java.util.List;

public class ListDeep {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(2); // 배열의 길이를 몇개짜리로 잡아둘건지 : 2개
        System.out.println(intList.hashCode());
        intList.add(1);
        System.out.println(intList.hashCode());
        intList.add(2);
        System.out.println(intList.hashCode()); // 힙메모리에 저장된 해시값을 가져옴
        intList.add(3);
        System.out.println(intList.hashCode());

        long startTime = System.nanoTime();
        List<String> unoptimized = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            unoptimized.add("책"+i);
        }
        long endTime = System.nanoTime();
        long unoptimizedDuration = endTime - startTime; // 총 동작 시간

        startTime = System.nanoTime();
        List<String> optimized = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            optimized.add("책"+i);
        }
        endTime = System.nanoTime();
        long optimizedDuration = endTime - startTime;

        System.out.println("비최적화 리스트 요소 시간 : "+unoptimizedDuration);
        System.out.println("최적화 리스트 소요 시간 : "+optimizedDuration);
    }
}
