package pers.xiaomuma.example.auth.service.config;


import com.google.common.collect.Lists;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.xiaomuma.example.auth.service.constant.DataSourceNames;
import pers.xiaomuma.framework.support.database.MultipleDataSource;


@Configuration
@MapperScan(basePackages = "pers.xiaomuma.example.auth.service.crud.modules.*.dao")
public class DataSourceConfiguration {

    @Bean("multipleDataSource")
    public MultipleDataSource multipleDataSource() {
        return new MultipleDataSource(Lists.newArrayList(
                DataSourceNames.EXAMPLE_AUTH_READ,
                DataSourceNames.EXAMPLE_CLIENT_READ
        ));
    }

}
