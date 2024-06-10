package pers.johns.springboot.blog.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

/**
 * ClassName    : ArticleException
 * <br/>
 * Description  : 文章异常
 * <br/>
 * CreateTime   : 2024/6/10 14:21
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */
public class ArticleException extends ErrorResponseException {
    public ArticleException(HttpStatusCode status, String detail) {
        super(status, getProblemDetail(status, detail), null);
    }

    public static ProblemDetail getProblemDetail(HttpStatusCode status, String detail) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, detail);

        problemDetail.setTitle("文章操作错误");

        return problemDetail;
    }
}
