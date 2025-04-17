package com.ohgiraffers.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointerExceptionTest() {
        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e) {
        System.out.println("controller 레벨의 exception 처리");
        return "error/nullPointer";
    }

    @GetMapping("controller-user")
    public String controllerUser() throws MemberRegistException {
        boolean check = true;
        if (check) {
            throw new MemberRegistException("당신은 회원이 될 수 없습니다.");
        }
        return "/";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String memberRegistException(Model model, MemberRegistException e) {
        System.out.println("controller 레벨의 exception 처리");
        model.addAttribute("exception", e);
        return "error/memberRegist";
    }
}
