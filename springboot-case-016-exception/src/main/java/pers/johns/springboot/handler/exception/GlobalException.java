package pers.johns.springboot.handler.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName    : GlobalException
 * Description  : 异常处理器
 * CreateTime   : 2024/6/7 23:15
 *
 * @author : JohnS
 * @version : 1.0
 */

@ControllerAdvice
public class GlobalException {

    /**
     * 处理算数异常
     *
     * @param exception 算数异常
     * @param model     数据绑定
     * @return 展示视图
     */
    @ExceptionHandler(ArithmeticException.class)
    public String handlerArithmeticException(ArithmeticException exception, Model model) {
        String error = exception.getMessage();
        model.addAttribute("errorMessage", error);
        return "error/arithmetic";
    }

    /**
     * 处理全部异常
     *
     * @param exception 任意异常
     * @return 展示视图
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handlerException(Exception exception) {
        Map<String, Object> errorMap = new HashMap<>();
        String errorMessage = exception.getMessage();

        errorMap.put("errorMessage", errorMessage);
        errorMap.put("tips", "未知异常，请联系管理员");

        return errorMap;
    }
}
