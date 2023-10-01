package actuator.order.v1;

import actuator.order.OrderService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV1 implements OrderService {

    private final MeterRegistry registry;
    private AtomicInteger stock = new AtomicInteger(100); // 재고

    public OrderServiceV1(MeterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet(); // 값 줄어듬

        // 카운터 메트릭 생성 및 증가
        Counter.builder("my.order") // 이름
                .tag("class", this.getClass().getName()) // 태그
                .tag("method", "order") // 태그
                .description("order") // 설명
                .register(registry)
                .increment(); // 증가
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet(); // 값 늘림

        // 카운터 메트릭 생성 및 증가
        Counter.builder("my.order") // 이름
                .tag("class", this.getClass().getName()) // 태그
                .tag("method", "cancel") // 태그
                .description("cancel") // 설명
                .register(registry)
                .increment(); // 증가
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
