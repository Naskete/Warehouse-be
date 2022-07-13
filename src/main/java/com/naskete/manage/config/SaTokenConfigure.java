package com.naskete.manage.config;

import cn.dev33.satoken.jwt.StpLogicJwtForStyle;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaTokenConfigure {
    @Bean
    public StpLogic getStpLogicJwt(){
        return new StpLogicJwtForStyle();
    }
}

