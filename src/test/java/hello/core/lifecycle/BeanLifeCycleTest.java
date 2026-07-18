package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        //AnnotationConfigApplicationContext 상위 인터페이스 -> ConfigurableApplicationContext
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetWorkClient client = ac.getBean(NetWorkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetWorkClient netWorkClient() {
            NetWorkClient netWorkClient = new NetWorkClient();
            netWorkClient.setUrl("http://hello-spring.dev");
            return netWorkClient;
        }
    }
}
