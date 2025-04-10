package com.ohgiraffers.servlet.chap01;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/*
* @WebServlet
* 해당 클래스가 서블릿 클래스임을 명시하는 어노테이션으로
* 동적이고 http 요청을 처리하는 웹 컴포넌트를 만들 수 있게 해준다.
*
* value 속성은 서블릿이 매핑될 url 패턴을 지정하며, 여기서는 /life-cycle로 들어오는 요처을 처리하게 된다.
* */
@WebServlet(name = "servletLifecycle", value = "/life-cycle")
public class ServletLifeCycle extends HttpServlet {

    /* 애플리케이션이 동작되면 서블릿이 생성이 되었다가 url 매핑이 되면 그때 초기화됨
    * init 메서드 : 서블릿 초기화 단계
    * - 서블릿이 처음 생성될 때 한 번 호출된다.
    * - 주로 서블릿이 사용할 자원(예 : 데이터베이스 연결, 설정 파일 로드 등)을 준비하는데 사용된다. + IO가 많이 일어나는 작업들을 여기서 한다
    * */
    @Override
    public void init() throws ServletException { // DB 커넥션 리소스를 제공할 수 있도록?
        super.init(); // init과 생성자의 차이는?
    }

    /*
    * service
    * - 클라이언트로부터 요청이 올 때마다 호출된다.
    * - 요청의 종류 (GET, POST 등)에 따라 적절한 doGet, doPost 메서드로 라우팅하는 역할
    * - 서블릿의 핵심 동작이 이 단계에서 이루어지게 된다.
    * */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /*
        * servletRequest
        * 클라이언트로부터 서버로 전송된 요청을 표현하며, 요청 데이터(파라미터, 헤더, 입력 스트림 등)을 캡슐화한다.
        * 이를 통해 서블릿은 클라이언트의 의도를 파악하고 필요한 데이터를 추출할 수 있다.
        * */
        // 다운캐스팅
        HttpServletRequest request = (HttpServletRequest) req; // (HttpServletResponse) 는 인터페이스타입이기 떄문에 나중에 톰캣말고 다른거 쓸 때를 위해 형변환? 모르겠다

        /*
        * servletResponse
        * 서버가 클라이언트에게 보낼 응답을 나타내며, 응답 데이터(출력 스트림, 상태 코드, 헤더 등)을 설정하는 역할을 한다.
        * 이를 통해 서블릿은 처리 결과를 클라이언트에게 전달할 수 있게 된다.
        * */
        HttpServletResponse response = (HttpServletResponse) res;

        // 클라이언트의 요청 메서드를 가져온다.
        String method = request.getMethod();

        if("GET".equals(method)) {
            doGet(request, response);
        } else if("POST".equals(method)) {
            doPost(request, response);
        } else {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h1>지원하지 않는 http 메서드 입니다.</h1>");
        }
    }

    /* doPost 메서드 : POST 요청 처리 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head> <title> post응답 </title> </head>");
        out.println("<body>");
        out.println("<h1> POST 요청을 처리했습니다. </h1>");
        out.println("<p> 이 내용은 서블릿에서 직접 생성된 응답입니다. </p>");
        out.println("</body>");
        out.println("</html>");
    }

    /* doGet 메서드 : GET 요청 처리 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.sendRedirect(req.getContextPath() + "/chap01/index.html");
    }

    /*
    * destroy
    * - 서블릿이 메모리에서 제거될 때 호출됨
    * - 자원을 정리하거나 마무리 작업 (파일이나 db리소스같은거 제거)
    * */
    @Override
    public void destroy() {
        super.destroy();
    }
}