package pers.johns.springboot.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;

/**
 * ClassName    : IsbnNotFoundException
 * Description  :
 * CreateTime   : 2024/6/8 19:37
 *
 * @author : JohnS
 * @version : 1.0
 */

public class IsbnNotFoundException extends ErrorResponseException {

    private static final String PROBLEM_PATH = "/problem/not-found";

    public IsbnNotFoundException(HttpStatus httpStatus, String detail, HttpServletRequest request) {
        super(httpStatus, getProblemDetail(httpStatus, detail, request), new BookNotFoundException(detail));
    }

    private static ProblemDetail getProblemDetail(HttpStatus httpStatus, String detail, HttpServletRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, detail);

        problemDetail.setType(URI.create(request.getContextPath() + PROBLEM_PATH));
        problemDetail.setProperty("problem-level", "low");
        problemDetail.setProperty("email", "service@johns.pers");

        return problemDetail;
    }
}
