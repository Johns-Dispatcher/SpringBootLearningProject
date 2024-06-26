package pers.johns.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pers.johns.springboot.formatter.DeviceFormatter;
import pers.johns.springboot.interceptor.ArticleInterceptor;

/**
 * ClassName    : SpringMvcConfig
 * Description  : 进行Web相关配置
 * CreateTime   : 2024/6/7 13:25
 *
 * @author : JohnS
 * @version : 1.0
 */

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DeviceFormatter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ArticleInterceptor())
                .addPathPatterns("/article/**")
                .excludePathPatterns("/article/query")
                .order(1);
    }
}
