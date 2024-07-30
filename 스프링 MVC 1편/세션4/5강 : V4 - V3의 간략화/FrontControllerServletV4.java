package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//"/front-controller/v1/*" -> /front-controller/v1/으로 들어오는 URL은 이 클래스를 실행
@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV4.service");

        //사용자가 입력한 URI를 가져옴
        String requestURI = request.getRequestURI();

        ControllerV4 controller = controllerMap.get(requestURI);

        //해당 URL이 없다면
        if(controller == null){

            //SC_NOTFOUND(=404) 형태의 html을 띄움
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        //request(username, age) 받기
        Map<String,String>paramMap = createParamMap(request);

        //추가 코드
        Map<String,Object> model = new HashMap<>();

        //개별 Controller에 대한 정보 받기
        //model에 각 controller가 실행한 내용이 담김
        String viewName = controller.process(paramMap, model);


        //Controller의 이름을 jsp호출을 할 수 있게끔 주소로 변경
        //  /WEB-INF/views/new-form/jsp
        MyView view = viewResolver(viewName);

        //MVC-view로 이동
        view.render(model, request,response);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        //요청(request)받은 username, age를 꺼내기
        //예시 : String username = request.getParameter("username");
        //예시 : int age = Integer.parseInt(request.getParameter("age"));

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }
}
