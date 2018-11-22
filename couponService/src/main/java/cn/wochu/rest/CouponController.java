package cn.wochu.rest;

import cn.wochu.config.ServiceInfoUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @RequestMapping("/couponDist/{taskid}")
    public String couponDist(@PathVariable("taskid")String taskid){
        int port = ServiceInfoUtil.getPort();
        System.out.println("分发批次号为：" + taskid + " 的券码");
        return "couponService receive request and response ok,excute server port is " + port;
    }

}
