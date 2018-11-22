package cn.wochu.rest;

import cn.wochu.config.ServiceInfoUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @RequestMapping("/orderAdd/{orderId}/{createdate}")
    public String orderAdd(@PathVariable("orderId")String orderId,@PathVariable("createdate")String createdate){
        int port = ServiceInfoUtil.getPort();
        if("9001".equals(port)){
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        StringBuilder stringBuilder = new StringBuilder("orderservice receive request,response info:");
        stringBuilder.append(orderId).append("---->").append(createdate).append("---->").append(port);
        return stringBuilder.toString();
    }

    @RequestMapping("/orderCount")
    public int orderCount(){
        Random random = new Random();
        return random.nextInt(1000);
    }

}
