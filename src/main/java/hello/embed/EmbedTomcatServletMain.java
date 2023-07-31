package hello.embed;

import hello.servlet.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class EmbedTomcatServletMain {

    public static void main(String[] args) throws LifecycleException {
        System.out.println("EmbedTomcatServletMain.main");
        // 톰캣 설정
        Tomcat tomcat = new Tomcat(); // 톰캣 생성
        Connector connector = new Connector(); // 연결 커넥터
        connector.setPort(8080); // 서버 포트 8080 설정
        tomcat.setConnector(connector); // 톰캣 연동

        // 서블릿 등록
        Context context = tomcat.addContext("", "/");

        File docBaseFile = new File(context.getDocBase());

        if (!docBaseFile.isAbsolute()) {

            docBaseFile = new File(((org.apache.catalina.Host) context.getParent()).getAppBaseFile(), docBaseFile.getPath());

        }

        docBaseFile.mkdirs();

        tomcat.addServlet("", "helloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello-servlet", "helloServlet");
        tomcat.start();
    }
}
