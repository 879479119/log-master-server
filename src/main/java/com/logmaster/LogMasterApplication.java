package com.logmaster;

import com.logmaster.api.interceptors.PermissionInterceptor;
import com.logmaster.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@MapperScan("com.logmaster.mapper")
@SpringBootApplication
public class LogMasterApplication extends WebMvcConfigurerAdapter {
    @Value("${com.wanlei.name}")
    private String name;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor()).addPathPatterns("/**").excludePathPatterns("/api/user/login");
    }


    public static void main(String[] args) {
		SpringApplication.run(LogMasterApplication.class, args);
	}
}
