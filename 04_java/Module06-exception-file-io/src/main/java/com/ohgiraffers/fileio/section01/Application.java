package com.ohgiraffers.fileio.section01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        // buffer -> flush
        // try 블럭 안의 소괄호는 리소스를 닫아줘야 하는 행위를 했을 때 finally를 안써도 됨
        try(FileWriter writer = new FileWriter("output.txt")) { // 상대경로의 기본은 프로젝트 기본 루트
            // 두 줄이 띄어쓰기 안되고 바로 붙음
            writer.write("hello Ohgiraffers");
            writer.write("this is a test file");

            writer.flush(); // flush를 쓰면 버퍼의 값이 작성됨

            System.out.println("파일 작성 완료");

            writer.close(); // 이건 try (여기서 열었다가 닫아주기 때문에) 생략가능
        } catch (IOException e) {
            System.out.println("파일 쓰기 실패");
        }

        try (FileReader reader = new FileReader("output.txt")) {
            int data;
            while((data = reader.read()) != -1) { // -1은 더이상 읽을 값이 없다고 표현할 때
                System.out.print((char)data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다." + e.getMessage());
        } catch (IOException e) {
            System.out.println("파일 읽기 실패 : " + e.getMessage());
        }
    }
}
