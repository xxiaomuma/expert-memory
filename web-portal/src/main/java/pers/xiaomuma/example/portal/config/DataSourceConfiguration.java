package pers.xiaomuma.example.portal.config;

import com.google.common.collect.Lists;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.xiaomuma.example.portal.constant.DataSourceNames;
import pers.xiaomuma.framework.support.database.MultipleDataSource;

@Configuration
@MapperScan("pers.xiaomuma.example.portal.crud.dao")
public class DataSourceConfiguration {

    @Bean("multipleDataSource")
    public MultipleDataSource multipleDataSource() {
        return new MultipleDataSource(Lists.newArrayList(
                DataSourceNames.WEB_EXAMPLE_WRITE,
                DataSourceNames.WEB_EXAMPLE_READ
        ));
    }
}
