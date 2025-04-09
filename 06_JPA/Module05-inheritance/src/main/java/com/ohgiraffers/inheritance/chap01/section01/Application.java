package com.ohgiraffers.inheritance.chap01.section01;

import com.ohgiraffers.inheritance.chap01.section01.model.ClothingProduct;
import com.ohgiraffers.inheritance.chap01.section01.model.ElectronicProduct;
import com.ohgiraffers.inheritance.chap01.section01.model.FoodProduct;

import java.time.LocalDate;

/*
* 잘못된 설계 : 상속 없이 별도의 클래스로 관리
* - ElectronicProduct, ClothingProduct,FoodProduct의 공통 속성 (name, price 등)을 가지지만, 별도의 클래스로 관리.
* - 공통 속성을 각각 정의해야 하므로 코드 중복 발생.
* - 데이터베이스에서도 별도의 테이블로 관리되므로, 공통 속성을 조회하거나 관리하기 위한 추가 로직 필요
* */
public class Application {
    public static void main(String[] args) {
        ElectronicProduct product = new ElectronicProduct("laptop", 999.999, "techBrand", 50,20);
        ClothingProduct clothing = new ClothingProduct("T-shirt", 19.99, "FashionBrand", 100,"M", "cotton");
        FoodProduct food = new FoodProduct("milk", 2.99, "foodBrand", 200, LocalDate.now().plusDays(7), true);


        System.out.println(product);
        System.out.println(clothing);
        System.out.println(food);
        // 상속을 사용하지 않으면 공통 속성을 관리하기 위한 추가 로직이 필요
        // 예 모든 상품의 가격을 조회하려면 클래스를 각각 처리해야 함
        /*
        * 문제점
        * - 공통 속성이 중복 정의됨
        * - 데이터베이스에서도 테이블이 별도로 생성되어야함.
        * - 공통 속성을 조회하기 위해서 세 테이블을 각각 조회해야 함.
        * - 새로운 상품 유형을 추가하면 새로운 클래스를 만들어야함.
        * */


    }
}
