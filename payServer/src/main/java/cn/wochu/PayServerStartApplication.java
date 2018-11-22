package cn.wochu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableHystrixDashboard //启用hystrix监控
public class PayServerStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayServerStartApplication.class,args);
    }
}
