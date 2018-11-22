package cn.wochu.config.fallbackConfig;

import cn.wochu.feign.CouponRemoteService;
import org.springframework.stereotype.Component;

@Component
public class CouponRemoteHystrix implements CouponRemoteService {

    @Override
    public String couponDist(String taskid) {
        return "发券服务暂不能使用，请稍后。。。。。。。。。。";
    }
}
