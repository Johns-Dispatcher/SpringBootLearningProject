package pers.johns.springboot.servlet.web.config;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import pers.johns.springboot.servlet.web.filter.LogFilter;
import pers.johns.springboot.servlet.web.servlet.LoginServlet;

/**
 * ClassName    : WebAppConfig
 * Description  : 注册Servlet/Filter
 * CreateTime   : 2024/6/7 9:58
 *
 * @author : JohnS
 * @version : 1.0
 */

@Configuration
public class WebAppConfig {

    /**
     * 配置自定义Servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean<HttpServlet> getLoginServlet() {
        ServletRegistrationBean<HttpServlet> registrationBean = new ServletRegistrationBean<>();

        registrationBean.setServlet(new LoginServlet());
        registrationBean.addUrlMappings("/loginServlet");
        registrationBean.setLoadOnStartup(1);

        return registrationBean;
    }

    /**
     * 配置自定义过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<Filter> getLogFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;
    }

    /**
     * 配置字符编码过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<Filter> getCharacterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceResponseEncoding(true);
        characterEncodingFilter.setForceRequestEncoding(true);

        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(characterEncodingFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(0);

        return filterRegistrationBean;
    }

    /**
     * 配置请求日志过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<Filter> get() {
        CommonsRequestLoggingFilter commonsRequestLoggingFilter = new CommonsRequestLoggingFilter();

        commonsRequestLoggingFilter.setIncludeQueryString(true);

        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(commonsRequestLoggingFilter);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
