package pers.johns.springboot.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import pers.johns.springboot.service.AlbumService;
import pers.johns.springboot.service.CommentService;
import pers.johns.springboot.service.TodoService;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

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

    /**
     * 创建 TodoService 接口的代理对象
     *
     * @return TodoService 代理对象
     */
    @Bean
    public TodoService getTodoService() {
        WebClient webClient =
                WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();

        // HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();

        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();

        return httpServiceProxyFactory.createClient(TodoService.class);
    }

    /**
     * 创建 AlbumService 接口的代理对象
     *
     * @return AlbumService 代理对象
     */
    @Bean
    public AlbumService getAlbumService() {
        WebClient webClient = WebClient.create();
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
        return httpServiceProxyFactory.createClient(AlbumService.class);
    }

    /**
     * 创建 CommentService 接口的代理对象
     *
     * @return CommentService 代理对象
     */
    @Bean
    public CommentService getCommentService() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000)
                .doOnConnected(connection -> {
                    // 读超时设置
                    connection.addHandlerLast(new ReadTimeoutHandler(10));
                    // 写超时设置
                    connection.addHandlerLast(new WriteTimeoutHandler(10));
                });

        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                // 设置异常处理
                .defaultStatusHandler(HttpStatusCode::isError, clientResponse -> {
                    System.out.println("WebClient Request Error!!");
                    return Mono.error(new RuntimeException("Request Exception: " + clientResponse.statusCode().value()));
                }).build();

        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();

        return httpServiceProxyFactory.createClient(CommentService.class);
    }
}
