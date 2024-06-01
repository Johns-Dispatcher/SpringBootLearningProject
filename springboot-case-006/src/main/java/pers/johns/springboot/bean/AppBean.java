package pers.johns.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * ClassName    : AppBean
 * Description  : 配置注入至Bean
 * CreateTime   : 2024/6/1 15:04
 *
 * @author : JohnS
 * @version : 1.0
 */

// @Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "app")
public class AppBean {

    private String name;
    private Integer port;

    public AppBean() {
    }

    public AppBean(String name, Integer port) {
        this.name = name;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "AppBean{" +
                "name='" + name + '\'' +
                ", port=" + port +
                '}';
    }
}
