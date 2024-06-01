package pers.johns.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName    : NestAppBean
 * Description  : 嵌套配置的注入
 * CreateTime   : 2024/6/1 16:53
 *
 * @author : JohnS
 * @version : 1.0
 */


// @Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "app1")
public class NestAppBean {
    private String name;
    private Integer port;
    private Security security;

    public NestAppBean() {
    }

    public NestAppBean(String name, Integer port, Security security) {
        this.name = name;
        this.port = port;
        this.security = security;
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

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    @Override
    public String toString() {
        return "NestAppBean{" +
                "name='" + name + '\'' +
                ", port=" + port +
                ", security=" + security +
                '}';
    }
}
