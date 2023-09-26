package external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

/**
 * 커맨드 라인 인수는 key=value 형식으로 사용하기 어렵다.
 * 그렇기 때문에 스프링은 커맨드 라인 인수를 key=value 형식으로 사용할 수 있게 기능을 제공한다.
 */
@Slf4j
public class CommandLineV2 {

    // --url=devdb --username=dev_user --password=dev_pw mode=on
    public static void main(String[] args) {
        // 메인 메서드 인수
        for (String arg : args) {
            log.info("arg {}", arg);
        }

        // 스프링에서 커맨드 라인 인수를 파싱해주는 기능을 제공한다.
        ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs())); // 모든 옵션 인수
        log.info("NonOptionArgs = {}", appArgs.getNonOptionArgs()); // '--'가 없는 옵션 인수
        log.info("OptionNames = {}", appArgs.getOptionNames()); // '--'가 있는 옵션 인수

        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option arg {} = {}", optionName, appArgs.getOptionValues(optionName));
        }
    }
}
