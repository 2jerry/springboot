package com.rubypaper.jdbc.config;


import com.rubypaper.jdbc.util.JDBCConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스는 환경구성 파일이다!, 자동으로 빈으로 등록된다.
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {

    @Autowired
    private JDBCConnectionManagerProperties properties;

    @Bean // Bean이다 이 객체도 빈으로 등록 됨
    @ConditionalOnMissingBean
    public JDBCConnectionManager getJDBCConnectionManager() {
        JDBCConnectionManager manager = new JDBCConnectionManager();

        manager.setDriverClass(properties.getDriverClass());
        manager.setUrl(properties.getUrl());
        manager.setUsername(properties.getUsername());
        manager.setPassword(properties.getPassword());

        return manager;
    }

}
