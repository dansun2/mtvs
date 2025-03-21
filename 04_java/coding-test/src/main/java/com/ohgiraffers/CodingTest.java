package com.ohgiraffers;

import java.util.Scanner;

public class CodingTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) { // 몇줄까지 출력할건지 도는 for문
            for (int j = 1; j <= n-i; j++) { // 공백을 출력하는 for 문
                System.out.print(" ");
            }
            for (int k = 1; k <= 2*i-1; k++) { // *을 출력하는 for 문
                System.out.print("*");
            }
            System.out.println(" "); // 한 줄이 완성되면 다음줄로 내려감
        }
        for (int i = n-1; i > 0; i--) { // i는 4부터 시작. 3
            for (int j = n-1; j >= i; j--) { // 공백을 1개 찍어야됨, 3
                System.out.print(" ");
            }
            for (int k = 1; k <= 2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
