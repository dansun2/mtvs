package com.ohgiraffers.oop.chap03.section02.deep.mission02.model;

import java.util.ArrayList;

public class Company {
    private String companyName;
    private ArrayList<Employee> employees;

    public Company(String companyName) {
        this.companyName = companyName;
        employees = new ArrayList<Employee>();
    }
}
