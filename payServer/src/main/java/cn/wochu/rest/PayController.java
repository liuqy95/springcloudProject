package cn.wochu.rest;

import cn.wochu.config.MyJdbcConfig;
import cn.wochu.feign.CouponRemoteService;
import cn.wochu.feign.OrderRemoteService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController extends BaseController{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CouponRemoteService couponRemoteService;

    @Autowired
    private OrderRemoteService orderRemoteService;

    @Autowired
    private MyJdbcConfig myJdbcConfig;

    @Autowired
    private HttpHeaders httpHeaders;

    @RequestMapping("/sessionId")
    public String getSessionId(){
       String sessionId = getHttpServletRequest().getSession().getId();
       return "current sessionId is ---> " + sessionId;
    }

    @RequestMapping("/payZipKin")
    public String pay(){
        String requestURL = "http://wochu-coupon-Service/coupon/zipKinRequest";
        //String resultInfo = restTemplate.getForObject(requestURL,String.class);
        String resultInfo2 = restTemplate.exchange(requestURL, HttpMethod.GET,new HttpEntity<>(httpHeaders),String.class).toString();
        String resultInfo3 = restTemplate.exchange(requestURL, HttpMethod.GET,new HttpEntity<>(httpHeaders),String.class).getBody();
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("resultInfo2",resultInfo2);
        returnMap.put("resultInfo3",resultInfo3);

        JSONObject jsonObject = new JSONObject(returnMap);
        return jsonObject.toJSONString();
    }

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
        resultMap.put("jdbcInfo",myJdbcConfig.toString());
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
