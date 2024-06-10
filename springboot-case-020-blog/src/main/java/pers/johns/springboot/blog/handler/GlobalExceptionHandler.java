package pers.johns.springboot.blog.handler;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * ClassName    : GlobalExceptionHandler
 * <br/>
 * Description  : TODO
 * <br/>
 * CreateTime   : 2024/6/10 17:40
 * <br/>
 *
 * @author : JohnS
 * @version : 1.0
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public String handlerBindException(BindException exception, Model model) {
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        model.addAttribute("errors", fieldErrors);
        return "/blog/error/bind";
    }
}
