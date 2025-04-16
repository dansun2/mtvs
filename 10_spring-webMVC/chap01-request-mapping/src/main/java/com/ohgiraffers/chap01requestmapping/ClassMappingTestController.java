package com.ohgiraffers.chap01requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
*
* */
@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    @GetMapping("/regist")
    public String registOrder(Model model) {
        model.addAttribute("message", "get 방식의 주문 등록용 핸들러 메소드 호출함");
        return "mappingResult";
    }

    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyDelete(Model model) {
        model.addAttribute("message", "post 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출");
        return "mappingResult";
    }

    // Path Value
    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(@PathVariable("orderNo") String orderNo, Model model) {
        model.addAttribute("message", orderNo);;
        return "mappingResult";
    }

    @RequestMapping
    public String otherRequest(Model model) {
        model.addAttribute("message","order 요청이 들어왔는데 아직 기능은 준비하지 않음");
        return "mappingResult";
    }
}
