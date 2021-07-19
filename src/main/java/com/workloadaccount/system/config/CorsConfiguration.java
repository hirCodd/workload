package com.workloadaccount.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @since 1.0.0
 * @version 1.0.0
 */

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    /**
     * 跨域请求访问控制
     * @param registry 跨域请求参数
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("POST", "GET")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .maxAge(1800L);
    }
}