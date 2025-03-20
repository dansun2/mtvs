package com.ohgiraffers.fileio.section02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("저장할 메세지를 입력해주세요 : ");
        String message = scanner.nextLine();

        // BufferedWriter는 io가 생기는 것을 최소한으로 시켜서 FileWriter 보다 빠름
        // Buffer(임시 메모리 공간)에 두고 한 번에 저장시킴
        // 프로그램을 여러 번 동작시키면 기존 파일에 덮어쓰기됨
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_input.txt"))
//             Scanner sc = new Scanner(message) 이렇게도 가능함
        ) {
            writer.write("사용자 입력 : " + message);
            writer.newLine();
            writer.write("작성 시간 : " + java.time.LocalDateTime.now());
            writer.flush();
            System.out.println("파일 저장 완료");
        } catch (IOException e) {
            System.out.println("파일 저장 실패 : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
