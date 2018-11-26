package cn.wochu.feign;

import cn.wochu.config.FeignConfig;
import cn.wochu.config.fallbackConfig.OrderRemoteHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "wochu-order-Server",path = "/orders",configuration = FeignConfig.class,fallback = OrderRemoteHystrix.class)
public interface OrderRemoteService {

    @GetMapping("/orderAdd/{orderId}/{createdate}")
    public String orderAdd(@PathVariable("orderId") String orderId,@PathVariable("createdate")String createdate);

    @GetMapping("/orderCount")
    public int orderCount();
}
