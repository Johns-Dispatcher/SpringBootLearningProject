package pers.johns.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.johns.springboot.model.pojo.Comment;
import pers.johns.springboot.service.CommentService;

/**
 * ClassName    : CommentTest
 * Description  :
 * CreateTime   : 2024/6/9 21:58
 *
 * @author : JohnS
 * @version : 1.0
 */

@SpringBootTest
public class CommentTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void testQuery() {
        Comment comment = commentService.getById(-1);
        System.out.println(comment);
    }
}
