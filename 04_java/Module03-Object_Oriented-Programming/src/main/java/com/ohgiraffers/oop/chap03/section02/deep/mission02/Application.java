package com.ohgiraffers.oop.chap03.section02.deep.mission02;

import com.ohgiraffers.oop.chap03.section02.deep.mission02.model.Company;
import com.ohgiraffers.oop.chap03.section02.deep.mission02.model.Employee;

public class Application {
    public static void main(String[] args) {
        Employee employee = new Employee("김철수", 30, "개발자", 5000);
        employee.introduce();
        employee.work();
    }
}
