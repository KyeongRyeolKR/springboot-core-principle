package external;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * 실행할 때, -D 옵션을 넣는것으로 사용
 * ex) java -Durl=devdb -jar [빌드파일]
 */
@Slf4j
public class JavaSystemProperties {

    public static void main(String[] args) {
        // JVM 시스템 속성
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("prop {} = {}", key, System.getProperty(String.valueOf(key)));
        }

        String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        log.info("url = {}", url);
        log.info("username = {}", username);
        log.info("password = {}", password);
    }
}
