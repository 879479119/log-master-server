package com.logmaster;

import com.logmaster.api.interceptors.PermissionInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@MapperScan("com.logmaster.mapper")
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class
})
public class LogMasterApplication extends WebMvcConfigurerAdapter {
    @Value("${com.wanlei.name}")
    private String name;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/type")
                .excludePathPatterns("/api/common")
                .excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/analysis/**")
                .excludePathPatterns("/api/contrast/**")
                .excludePathPatterns("/api/hybrid/**");
    }


    public static void main(String[] args) {
		SpringApplication.run(LogMasterApplication.class, args);
	}
}
