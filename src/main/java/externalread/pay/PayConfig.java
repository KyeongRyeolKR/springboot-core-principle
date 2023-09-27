package externalread.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * '@Profile' 은 '@Conditional' 기능을 활용해서
 * 특정 조건에 따라서 해당 빈을 등록할지 말지 선택하게 해준다!
 *
 * 결과적으로 '@profile' 을 사용하면 각 환경 별로 외부 설정 값을 분리하는 것을 넘어서,
 * 등록되는 스프링 빈도 분리할 수 있다!
 */
@Slf4j
@Configuration
public class PayConfig {

    @Bean
    @Profile("default") // 아무 프로필도 지정되지 않았을 때 등록되는 빈
    public LocalPayClient localPayClient() {
        log.info("LocalPayClient 빈 등록");
        return new LocalPayClient();
    }

    @Bean
    @Profile("prod") // prod 프로필이 지정되었을 때 등록되는 빈
    public ProdPayClient prodPayClient() {
        log.info("ProdPayClient 빈 등록");
        return new ProdPayClient();
    }
}
