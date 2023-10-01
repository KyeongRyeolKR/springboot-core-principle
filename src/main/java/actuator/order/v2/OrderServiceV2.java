package actuator.order.v2;

import actuator.order.OrderService;
import io.micrometer.core.annotation.Counted;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 스프링 AOP를 사용해서 카운터 메트릭을 만드는 방법
 * - @Counted("메트릭 이름")
 */
@Slf4j
public class OrderServiceV2 implements OrderService {

    private AtomicInteger stock = new AtomicInteger(100); // 재고

    @Counted("my.order")
    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet(); // 값 줄어듬
    }

    @Counted("my.order")
    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet(); // 값 늘림
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
