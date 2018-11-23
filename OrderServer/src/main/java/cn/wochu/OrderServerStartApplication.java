package cn.wochu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //表示开启断路器功能 可用于监控
public class OrderServerStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServerStartApplication.class,args);
    }
}
