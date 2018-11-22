package cn.wochu.rest;

import cn.wochu.feign.CouponRemoteService;
import cn.wochu.feign.OrderRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CouponRemoteService couponRemoteService;

    @Autowired
    private OrderRemoteService orderRemoteService;

    @RequestMapping("/paysuccess")
    @ResponseBody
    public Map<String,String> payCallback(){
        /**调用订单、发券服务**/
        StringBuilder orderUrl = new StringBuilder("http://wochu-order-Server").append("/orders/orderAdd/rty123/2018-11-21");
        StringBuilder couponUrl = new StringBuilder("http://wochu-coupon-Service").append("/coupon/couponDist/bfh123");

        String orderInfo = restTemplate.getForObject(orderUrl.toString(),String.class);

        String couponInfo = restTemplate.getForObject(couponUrl.toString(),String.class);

        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("orderInfo",orderInfo);
        resultMap.put("couponInfo",couponInfo);
        resultMap.put("code","success");
        return resultMap;
    }

    @RequestMapping("/payNotify")
    @ResponseBody
    public Map<String,String> payNotify(){

        String cReturn = couponRemoteService.couponDist("123456");
        String oReturn = orderRemoteService.orderAdd("abc456","2018-11-21");

        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("cReturn",cReturn);
        resultMap.put("oReturn",oReturn);
        return resultMap;
    }
}
