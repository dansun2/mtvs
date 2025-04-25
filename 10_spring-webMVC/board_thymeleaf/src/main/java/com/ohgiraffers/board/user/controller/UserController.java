package com.ohgiraffers.board.user.controller;

import com.ohgiraffers.board.user.model.dto.SignupDTO;
import com.ohgiraffers.board.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/signup")
    public void signup() {}

    @PostMapping("/signup")
    public String signup(@ModelAttribute SignupDTO signupDTO, ModelAndView mv, RedirectAttributes rdtat) {
        Integer result = userServiceImpl.signup(signupDTO);

        if (result == null) { // 사용자 중복일때
            rdtat.addFlashAttribute("errorMessage", "중복 회원이 존재합니다.");
            return "redirect:/user/signup";
        } else if (result == 0){ // 회원가입 실패
            rdtat.addFlashAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요");
            return "redirect:/user/signup";
        }

        // 회원가입 성공
        rdtat.addFlashAttribute("successMessage", "회원가입에 성공하였습니다!");
        return "redirect:/";
    }

}
