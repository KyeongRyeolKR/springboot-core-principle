package external;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 스프링은 Environment 를 통해서 모든 시스템 속성들을 읽을 수 있게 추상화를 했다.
 * (PropertySource 의 구현체들을 우선순위에 따라 전부 찾아서 클라이언트가 원하는 값을 찾아주는 방식)
 * 만약 JVM 시스템 속성을 사용하다가 커맨드 라인 옵션 인수를 사용하도록 바뀌어도 개발 소스는 전혀 변경하지 않아도 된다!
 *
 * - 변경되는 부분과 변경되지 않는 부분을 명확히 나눈 것이다!!
 */
@Slf4j
@Component
public class EnvironmentCheck {

    private final Environment env;

    public EnvironmentCheck(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        String url = env.getProperty("url");
        String username = env.getProperty("username");
        String password = env.getProperty("password");

        log.info("env url = {}", url);
        log.info("env username = {}", username);
        log.info("env password = {}", password);
    }
}
