package pers.johns.springboot.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import pers.johns.springboot.model.pojo.Comment;

/**
 * InterfaceName : CommentService
 * Description   :
 * CreateTime    : 2024/6/9 21:55
 *
 * @author : JohnS
 * @version : 1.0
 */

@HttpExchange("https://jsonplaceholder.typicode.com/comments")
public interface CommentService {

    @GetExchange("/{id}")
    Comment getById(@PathVariable Integer id);
}
