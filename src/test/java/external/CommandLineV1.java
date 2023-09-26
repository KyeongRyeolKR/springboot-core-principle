package external;

import lombok.extern.slf4j.Slf4j;

/**
 * 메인 메서드 인수는 기본 String 타입으로 넘어오기 때문에
 * key=value 형식으로 직접 파싱해야하는 번거로움이 있다.
 */
@Slf4j
public class CommandLineV1 {

    public static void main(String[] args) {
        // 메인 메서드 인수
        for (String arg : args) {
            log.info("arg {}", arg);
        }
    }
}
