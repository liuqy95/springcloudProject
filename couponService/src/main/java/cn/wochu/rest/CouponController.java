package cn.wochu.rest;

import cn.wochu.config.ServiceInfoUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @RequestMapping("/couponDist/{taskid}")
    public String couponDist(@PathVariable("taskid")String taskid){
        int port = ServiceInfoUtil.getPort();
        System.out.println("分发批次号为：" + taskid + " 的券码");
        return "couponService receive request and response ok,excute server port is " + port;
    }

    @RequestMapping("/couponCount")
    public Map<String,Object> couponCount(@RequestParam("date")String date){
        Map<String,Object> returnMap = new HashMap<>();
        Random random = new Random();

        returnMap.put("date",date);
        returnMap.put("num",random.nextInt(1000000));
        returnMap.put("port",ServiceInfoUtil.getPort());
        return returnMap;
    }

}
