package pers.xiaomuma.example.user.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
