package com.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.scripting.velocity.Driver;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan("com.test.mapper")
public class MapperConfiguration {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new CustomizedSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeHandlersPackage(DbCodeEnumTypeHandler.class.getPackage().getName());
        return sqlSessionFactoryBean;
    }

    private static class CustomizedSqlSessionFactoryBean extends SqlSessionFactoryBean {

        @Override
        protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
            SqlSessionFactory sqlSessionFactory = super.buildSqlSessionFactory();
            sqlSessionFactory.getConfiguration().setDefaultScriptingLanguage(Driver.class);
            sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
            return sqlSessionFactory;
        }

    }
}
