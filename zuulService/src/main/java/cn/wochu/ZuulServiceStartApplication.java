package cn.wochu;

import cn.wochu.filter.PreRequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulServiceStartApplication {

    @Bean
    public PreRequestFilter preRequestFilter(){
        return new PreRequestFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceStartApplication.class,args);
    }

}
