package pers.johns.springboot.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;
import pers.johns.springboot.model.pojo.Todo;

/**
 * InterfaceName : TodoService
 * Description   : 远程访问接口
 * CreateTime    : 2024/6/8 22:41
 *
 * @author : JohnS
 * @version : 1.0
 */


public interface TodoService {

    @GetExchange("/todos/{id}")
    Todo getTodoById(@PathVariable("id") Integer id);

    @PostExchange(value = "/todos/", accept = MediaType.APPLICATION_JSON_VALUE)
    Todo createTodo(@RequestBody Todo newTodo);

    @PutExchange("/todos/{id}")
    ResponseEntity<Todo> modifyTodo(@PathVariable Integer id, @RequestBody Todo todo);

    @DeleteExchange("/todos/{id}")
    void removeTodo(@PathVariable Integer id);
}
