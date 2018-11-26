package cn.wochu.feign;

import cn.wochu.config.FeignConfig;
import cn.wochu.config.fallbackConfig.CouponRemoteHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "wochu-coupon-Service",path = "/coupon",configuration = FeignConfig.class,fallback = CouponRemoteHystrix.class)
public interface CouponRemoteService {

    @GetMapping("/couponDist/{taskid}")
    public String couponDist(@PathVariable("taskid")String taskid);

}
