package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();

    //어댑터들을 담는 리스트
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5(){
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
    }

    //handlerAdapters에 버전3 담기
    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Controller 가져오기
        Object handler = getHandler(request);

        if(handler == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //handler의 버전을 가져옴
        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        //ModelView -> Controller의 수행 정보
        //해당 버전의 ModelView 가져옴
        ModelView mv = adapter.handle(request,response,handler);

        //해당 컨트롤러의 수행 명칭
        String viewName = mv.getViewName();

        //수행 명칭을 주소로 변환
        MyView view = viewResolver(viewName);

        //view로 가기
        view.render(mv.getModel(), request,response);

    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {

        // handlerAdapters에는 버전3이 담겨있음
        for(MyHandlerAdapter adapter : handlerAdapters)
        {
            //handler의 controller 버전이 어느 버전에 매칭되는 가 확인
            //매칭 되는 버전을 return
            if(adapter.supports(handler)){
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler = "+handler);
    }

    private Object getHandler(HttpServletRequest request)
    {
        //클라이언트가 접속한 URI 반환
        // ex) /front-controller/v5/v3/members/save(http://~~이거는 생략됨)
        String requestURI = request.getRequestURI();

        return handlerMappingMap.get(requestURI);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

}
