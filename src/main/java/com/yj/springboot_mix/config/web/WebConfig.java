package com.yj.springboot_mix.config.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

        @Value("#{'${corsconfig-list}'.split(',')}")
        private String[] white_list;

        private CorsConfiguration buildConfig() {
            CorsConfiguration corsConfiguration = new CorsConfiguration();

            if(white_list != null &&  white_list.length > 0){
                for (String ip : white_list) {
                    ip = ip.replaceAll(" " ,"");
                    corsConfiguration.addAllowedOrigin(ip);
                    System.out.println(ip);
                }
            }
            corsConfiguration.setAllowCredentials(true);
            corsConfiguration.addAllowedHeader("content-type");
            corsConfiguration.addAllowedMethod("GET");
            corsConfiguration.addAllowedMethod("POST");
            corsConfiguration.addAllowedMethod("OPTIONS");
            return corsConfiguration;
        }

        @Bean
        public CorsFilter corsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", buildConfig());
            return new CorsFilter(source);
        }
}