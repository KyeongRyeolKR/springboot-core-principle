package actuator.order.v3;

import actuator.order.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 타이머 메트릭
 * - 누적 실행 수(count), 실행 시간의 합(sum), 최대 실행 시간(max)
 */
@Slf4j
public class OrderServiceV3 implements OrderService {

    private final MeterRegistry registry;
    private AtomicInteger stock = new AtomicInteger(100); // 재고

    public OrderServiceV3(MeterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void order() {
        Timer timer = Timer.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "order")
                .description("order")
                .register(registry);

        timer.record(() ->{
            log.info("주문");
            stock.decrementAndGet(); // 값 줄어듬
            sleep(500);
        });
    }

    @Override
    public void cancel() {
        Timer timer = Timer.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "cancel")
                .description("cancel")
                .register(registry);

        timer.record(() -> {
            log.info("취소");
            stock.incrementAndGet(); // 값 늘림
            sleep(200);
        });
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis + new Random().nextInt(200));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

