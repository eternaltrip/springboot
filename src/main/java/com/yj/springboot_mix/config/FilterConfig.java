package com.yj.springboot_mix.config;


import com.yj.springboot_mix.config.filter.RequestMethodFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {


    @Bean
    public FilterRegistrationBean registFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new RequestMethodFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("requestMethodFilter");
        registrationBean.setOrder(0);
        return registrationBean;
    }

}
