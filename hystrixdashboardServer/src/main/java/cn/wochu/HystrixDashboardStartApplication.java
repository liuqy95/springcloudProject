package cn.wochu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard //启用hystrix监控
public class HystrixDashboardStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardStartApplication.class,args);
    }

}
