package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

/**
 * @WebServlet 어노테이션을 사용하면 간편하게 서블릿을 등록할 수 있는데, 대체 왜 프로그래밍 방식이 존재하는가?
 * -> 어노테이션을 사용한 방식은 유연한 변경이 어렵다. 예를 들어 '/test' 라는 매핑 경로를 바꾸고 싶다면 직접 바꿔야한다.
 *    그러나 프로그래밍 방식은 코딩량이 많고 불편하지만, 환경에 따른 매핑 정보 변동은 if문을 사용해 유연하게 설정 가능하고
 *    서블릿에 필요한 정보들을 직접 생성자에 넣어줄 수도 있다.
 */
public class AppInitV1Servlet implements AppInit {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV1Servlet.onStartup");

        // 순수 서블릿 코드 등록
        ServletRegistration.Dynamic helloServlet = servletContext.addServlet("helloServlet", new HelloServlet());
        helloServlet.addMapping("/hello-servlet");  // 서블릿 경로 매핑
    }
}
