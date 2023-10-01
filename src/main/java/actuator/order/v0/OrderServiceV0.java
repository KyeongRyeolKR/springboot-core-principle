package actuator.order.v0;

import actuator.order.OrderService;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV0 implements OrderService {

    private AtomicInteger stock = new AtomicInteger(100); // 재고

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet(); // 값 줄어듬
    }

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
