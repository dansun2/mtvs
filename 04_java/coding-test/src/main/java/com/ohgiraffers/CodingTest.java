package com.ohgiraffers;

import java.util.Scanner;

public class CodingTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 세 개의 숫자를 입력받음
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        if (num1 == num2 && num3 == num1) {
            System.out.println(10000+num1*1000);
        } else {
            if (num1 == num2) {
                System.out.println(1000+num1*100);
            } else if (num1 == num3) {
                System.out.println(1000+num1*100);
            } else if (num2 == num3) {
                System.out.println(1000+num2*100);
            } else {
                int maxNum = 0;
                maxNum = Math.max(Math.max(num1, num2), num3);
                System.out.println(maxNum);
            }
        }
    }
}
