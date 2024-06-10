package pers.johns.springboot.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName    : WebConfig
 * <br/>
 * Description  : 配置Web相关数据
 * <br/>
 * CreateTime   : 2024/6/10 11:59
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 设置资源处理路径
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/");
    }

    /**
     * 设置视图控制器
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("blog/articles");
    }
}
