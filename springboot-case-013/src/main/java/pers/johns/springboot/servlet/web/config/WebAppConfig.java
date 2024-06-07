package pers.johns.springboot.servlet.web.config;

import jakarta.servlet.http.HttpServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.johns.springboot.servlet.web.servlet.LoginServlet;

/**
 * ClassName    : WebAppConfig
 * Description  : 注册Servlet
 * CreateTime   : 2024/6/7 9:58
 *
 * @author : JohnS
 * @version : 1.0
 */

@Configuration
public class WebAppConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> getLoginServlet() {
        ServletRegistrationBean<HttpServlet> registrationBean = new ServletRegistrationBean<HttpServlet>();

        registrationBean.setServlet(new LoginServlet());
        registrationBean.addUrlMappings("/loginServlet");
        registrationBean.setLoadOnStartup(1);

        return registrationBean;
    }
}
