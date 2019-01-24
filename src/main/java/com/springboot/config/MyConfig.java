package com.springboot.config;


import com.springboot.component.LoginHandlerInterceptor;
import com.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ProjectName: springboot-web1
 * @Package: com.springboot.config
 * @ClassName: MyConfig
 * @Author: gnnt
 * @Date: 2019/1/23 15:29
 * @Version: 1.0
 */
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {

    /*配置视图解析器*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        /*浏览器发送crud会自动跳转到success页面*/
//        registry.addViewController("/hello").setViewName("success");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /*配置拦截器，不拦截登录页面和登录请求*/
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/user/login", "/asserts/**");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
