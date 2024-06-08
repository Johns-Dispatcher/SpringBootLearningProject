package pers.johns.springboot.handler.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.johns.springboot.exception.BookNotFoundException;

import java.net.URI;
import java.time.LocalDateTime;

/**
 * ClassName    : GlobalException
 * Description  : 全局异常处理器
 * CreateTime   : 2024/6/8 16:11
 *
 * @author : JohnS
 * @version : 1.0
 */

// @RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(BookNotFoundException.class)
    public ProblemDetail handlerBookNotFoundException(BookNotFoundException exception, HttpServletRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());

        problemDetail.setType(URI.create(request.getContextPath() + "/problem/not-found"));
        problemDetail.setTitle("图书未能找到");
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("email", "services@johns.pers");

        return problemDetail;
    }
}
