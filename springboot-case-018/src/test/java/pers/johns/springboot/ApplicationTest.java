package pers.johns.springboot;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import pers.johns.springboot.model.pojo.Todo;
import pers.johns.springboot.service.TodoService;

import java.util.Random;

/**
 * ClassName    : ApplicationTest
 * Description  :
 * CreateTime   : 2024/6/8 22:49
 *
 * @author : JohnS
 * @version : 1.0
 */

@SpringBootTest
public class ApplicationTest {

    @Resource
    private TodoService todoService;

    @Test
    public void testQueryTodo() {
        Todo todo = todoService.getTodoById(new Random().nextInt(10));
        System.out.println(todo);
    }

    @Test
    public void testCreateTodo() {
        Todo todo = new Todo();

        todo.setId(2001);
        todo.setTitle("Learning Todo");
        todo.setUserId(5001);
        todo.setCompleted(false);

        Todo createdTodo = todoService.createTodo(todo);
        System.out.println(createdTodo);
    }

    @Test
    public void testModifyTodo() {
        Todo todo = new Todo();

        todo.setTitle("Learning Todo");
        todo.setUserId(5011);
        todo.setCompleted(false);

        ResponseEntity<Todo> responseEntity = todoService.modifyTodo(20, todo);

        HttpHeaders headers = responseEntity.getHeaders();
        Todo body = responseEntity.getBody();
        HttpStatusCode statusCode = responseEntity.getStatusCode();

        System.out.println("Headers: " + headers);
        System.out.println("Response Body: " + body);
        System.out.println("Status Code: " + statusCode);
    }

    @Test
    public void testDelete() {
        todoService.removeTodo(15);
    }
}
