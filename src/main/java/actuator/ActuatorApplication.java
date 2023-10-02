package actuator;

import actuator.order.v0.OrderConfigV0;
import actuator.order.v1.OrderConfigV1;
import actuator.order.v2.OrderConfigV2;
import actuator.order.v3.OrderConfigV3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(OrderConfigV0.class)
//@Import(OrderConfigV1.class)
//@Import(OrderConfigV2.class)
@Import(OrderConfigV3.class)
@SpringBootApplication(scanBasePackages = "actuator.controller")
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

    /**
     * HTTP 요청 응답 기록
     * 최대 100개의 요청을 기록
     * URL : /actuator/httpexchanges
     */
    @Bean
    public InMemoryHttpExchangeRepository httpExchangeRepository() {
        return new InMemoryHttpExchangeRepository();
    }
}
