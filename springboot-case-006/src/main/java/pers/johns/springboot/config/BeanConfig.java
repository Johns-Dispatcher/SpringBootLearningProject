package pers.johns.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.johns.springboot.bean.Security;

/**
 * ClassName    : BeanConfig
 * Description  :
 * CreateTime   : 2024/6/1 18:19
 *
 * @author : JohnS
 * @version : 1.0
 */

@Configuration
public class BeanConfig {

    /**
     * 通过配置文件值初始化对象
     * @return Security对象
     */
    @ConfigurationProperties(prefix = "security")
    @Bean
    public Security getSecurity() {
        return new Security();
    }
}
