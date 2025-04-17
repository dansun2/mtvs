package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model) {
        model.addAttribute("forwardMessage", "문자열로 뷰 이름을 반환함");

        /*
        * 문자열로 뷰 이름을 반환한다는 것은 반환 후
        * ThymeleafViewResolver 에게 resources/templates/를 prefix로, .html을 suffix로 하여
        * resources/templates/result.html 파일을 응답 뷰로 설정하라는 의미가 된다.
        * */
        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect(Model model) {
        model.addAttribute("flashMessage1","테스트를 위한 값입니다.");
        // 접두사로 redirect:를 하게 되면 forward가 아닌 redirect 시키게 된다.
        return "redirect:/";
    }

    @GetMapping("string-redirect-attr")
    public String stringRedirectFlashAttribute(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("flashMessage1", "리다이렉트를 사용 redirect"); // addFlashAttribute는 세션저장소에 다음요청1회까지만 저장
        return "redirect:/";
    }

    @GetMapping("modelandview")
    public ModelAndView modelAndView(ModelAndView mv) {
        mv.addObject("forwardMessage","ModelAndView를 사용한 모델과 뷰 반환");
        mv.setViewName("result");
        return mv;
    }

    @GetMapping("modelandview-redirect")
    public ModelAndView modelaAndViewRedirect(ModelAndView mv) {
        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirect(ModelAndView mv, RedirectAttributes rttr) {
        rttr.addFlashAttribute("flashMessage2", "modelAndView를 활용한 redirect attr");
        return mv;
    }
}
