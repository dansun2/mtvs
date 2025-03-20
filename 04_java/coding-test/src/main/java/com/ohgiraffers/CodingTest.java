package com.ohgiraffers;

import java.util.Scanner;

public class CodingTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] number = new int[n];

        for (int i=0;i<number.length;i++){
            number[i] = sc.nextInt();
        }
        sc.close();

        int min = number[0];
        int max = number[0];

        for (int i=1;i<number.length;i++){
            min = Math.min(min,number[i]);
            max = Math.max(max,number[i]);
        }
        System.out.println(min + " " + max);
    }
}
