package cn.wochu;

import cn.wochu.filter.PreRequestFilter;
import cn.wochu.filter.RecodeNoteFilter;
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

    @Bean
    public RecodeNoteFilter recodeNoteFilter(){
        return new RecodeNoteFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceStartApplication.class,args);
    }

}
