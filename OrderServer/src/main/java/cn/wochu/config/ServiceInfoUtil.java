package cn.wochu.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceInfoUtil implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    private static EmbeddedServletContainerInitializedEvent embeddedServletContainerInitializedEvent;

    @Override
    public void onApplicationEvent(EmbeddedServletContainerInitializedEvent embeddedServletContainerInitializedEvent) {
        ServiceInfoUtil.embeddedServletContainerInitializedEvent = embeddedServletContainerInitializedEvent;
    }

    /**
     * 获取端口号
     * @return
     */
    public static int getPort(){
        int port = embeddedServletContainerInitializedEvent.getEmbeddedServletContainer().getPort();
        return port;
    }

}
