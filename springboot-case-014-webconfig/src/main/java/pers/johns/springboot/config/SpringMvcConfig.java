package pers.johns.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
}
