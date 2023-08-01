package hello.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class HelloConfig {
    // 직접 컨트롤러 빈 등록
    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
}
