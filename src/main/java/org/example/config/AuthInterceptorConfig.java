package org.example.config;


import org.example.bean.WhiteList;
import org.example.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class AuthInterceptorConfig implements WebMvcConfigurer {

    // 注入拦截器
    @Autowired
    private AuthInterceptor authInterceptor;
    @Resource
    WhiteList whiteList;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
                .excludePathPatterns(whiteList.getPass_url())
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**","/csrf","/", "/error");
    }

}
