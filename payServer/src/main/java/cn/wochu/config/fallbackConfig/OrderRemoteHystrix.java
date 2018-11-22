package cn.wochu.config.fallbackConfig;

import cn.wochu.feign.OrderRemoteService;
import org.springframework.stereotype.Component;

@Component
public class OrderRemoteHystrix implements OrderRemoteService {

    @Override
    public String orderAdd(String orderId, String createdate) {
        return "订单服务暂不能使用，请稍后。。。。。。。。。。。。";
    }

    @Override
    public int orderCount() {
        return 1000000000;
    }
}
