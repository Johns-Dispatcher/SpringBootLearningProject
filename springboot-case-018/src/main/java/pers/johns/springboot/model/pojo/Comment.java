package pers.johns.springboot.model.pojo;

/**
 * RecordName   : Comment
 * Description  :
 * CreateTime   : 2024/6/9 21:54
 *
 * @author : JohnS
 * @version : 1.0
 */
public record Comment(Integer id, Integer postId, String name, String email, String body) {
}
