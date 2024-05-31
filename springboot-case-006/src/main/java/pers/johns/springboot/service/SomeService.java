package pers.johns.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * ClassName    : SomeService
 * Description  :
 * CreateTime   : 2024/5/31 18:37
 *
 * @author : JohnS
 * @version : 1.0
 */

@Service
public class SomeService {

    @Value("${app.name}")
    private String name;
    @Value("${app.author:johns}")
    private String author;
    @Value("${app.port:8080}")
    private Integer port;

    public void printValue() {
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Port: " + port);
    }
}
