package actuator.order.v4;

import actuator.order.OrderService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 타이머 메트릭 - AOP 적용(@Timed)
 * - 누적 실행 수(count), 실행 시간의 합(sum), 최대 실행 시간(max)
 *
 * 클래스 레벨에 지정하면 모든 public 메서드에 적용된다!
 */
@Timed(value = "my.order")
@Slf4j
public class OrderServiceV4 implements OrderService {

    private AtomicInteger stock = new AtomicInteger(100); // 재고

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet(); // 값 줄어듬
        sleep(500);
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet(); // 값 늘림
        sleep(200);
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

