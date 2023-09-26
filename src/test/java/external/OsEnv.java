package external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OsEnv {

    public static void main(String[] args) {
        // 시스템 환경 변수
        Map<String, String> envMap = System.getenv();
        for (String key : envMap.keySet()) {
            log.info("env {} = {}", key, System.getenv(key));
        }
    }
}
