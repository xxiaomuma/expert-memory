package pers.xiaomuma.example.portal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import pers.xiaomuma.auth.framework.resource.server.annotation.EnableExternalResourceServer;
import pers.xiaomuma.framework.rpc.ServiceClientConfiguration;
import pers.xiaomuma.framework.support.cache.EnableRedisCache;
import pers.xiaomuma.framework.web.WebApplicationConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class, RabbitAutoConfiguration.class
})
@EnableRedisCache
@EnableDiscoveryClient
@Import({ServiceClientConfiguration.class, WebApplicationConfiguration.class})
@EnableExternalResourceServer
@EnableFeignClients(basePackages = {"pers.xiaomuma.example.portal.rpc"})
public class PortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }
}
