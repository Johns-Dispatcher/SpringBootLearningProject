package pers.johns.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import pers.johns.springboot.service.TodoService;

/**
 * ClassName    : HttpConfiguration
 * Description  : 配置远程访问的代理对象
 * CreateTime   : 2024/6/8 22:44
 *
 * @author : JohnS
 * @version : 1.0
 */

@Configuration(proxyBeanMethods = false)
public class HttpConfiguration {

    @Bean
    public TodoService getTodoService() {
        WebClient webClient =
                WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();

        // HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();

        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();

        return httpServiceProxyFactory.createClient(TodoService.class);
    }
}
