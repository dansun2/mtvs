package com.ohgiraffers.chap02handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id") // id라는 속성이 모델에 정의가 되면 그것을 session에도 저장하겠다.
public class FirstController {

    @GetMapping("regist")
    public void regist() {}

    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록하셨습니다.";
        System.out.println(message);
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify(){}

    @PostMapping("modify") // required = false는 값이 초기화되지 않으면 null값을 넣어줌
    public String modifyMenuPrice(Model model,
                                  @RequestParam(name = "modifyName", required = false) String modifyNam,
                                  @RequestParam(required = false) String modifyPrice) {
        String message = modifyNam + "의 가격을 " + modifyPrice + "원으로 수정합니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @PostMapping("modifyAll")
    // Map 형식으로 받으면 유지보수가 높아서 권장되지 않음. 왜냐면 view에서 name속성의 이름을 바꿨을때 바인딩이 안되거나 하면 디버깅이 힘듦. + 유효성 검사를 위한@Valid를 쓸 수 없음
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameters) {
        String modifyMenu = parameters.get("modifyMenu");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPrice"));
        String message = "메뉴의 이름을 " + modifyMenu + "으로, 가격을 " + modifyPrice + "원으로 변경합니다.";
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search() {

    }

    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {
        System.out.println(menu);
        return "first/searchResult";
    }

    @GetMapping("login")
    public void login() {}

    @PostMapping("login1")
    public String login1(HttpSession session, @RequestParam String id) {
        session.setAttribute("id", id);
        return "first/loginResult";
    }

    @GetMapping("logout1")
    public String logout1(HttpSession session) {
        session.invalidate();
        return "first/loginResult";
    }

    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id) {
        model.addAttribute("id", id);
        return "first/loginResult";
    }

    @GetMapping("logout2")
    public String logout2(SessionStatus status) {
        // 현재 컨트롤러 세션에 있는 모든 정보를 제거한다.
        status.setComplete();
        return "first/loginResult";
    }

    /* 5. @RequestBody를 이용하는 방법
    *
    * 해당 어노테이션은 http 본문 자체를 읽는 부분을 모델로 변환시켜 주는 어노테이션이다.
    * 출력해보면 쿼리스트링 형태의 문자열이 전송된다.
    * JSON으로 전달하는 경우 Jackson의 컨버터로 자동 파싱하여 사용할 수 있다.
    * 주로 RestAPI작성 시 많이 사용되며, 일반적인 form 전송을 할 때는 거의 사용하지 않는다.
    * 추가적으로 헤더에 대한 정보도
    * @RequestHeader 어노테이션을 이용해서 가져올 수 있다.
    * @CookieValue를 이용해서 쿠키 정보도 쉽게 불러올 수 있다.
    * */
    @PostMapping("body")
    public void bodyTest(@RequestBody String body,@RequestHeader("content-type") String contentType, @CookieValue(value="JSESSIONID", required = false) String sessionId) throws UnsupportedEncodingException {
        System.out.println(contentType);
        System.out.println(sessionId);
        System.out.println(body);
        System.out.println(URLDecoder.decode(body, "UTF-8"));}
}
