package pers.johns.springboot.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.StringJoiner;

/**
 * ClassName    : LogAspect
 * Description  : 日志切面类
 * CreateTime   : 2024/6/1 22:48
 *
 * @author : JohnS
 * @version : 1.0
 */

@Component
@Aspect
public class LogAspect {

    @Before("execution(* pers.johns.springboot.aop.service..*.*(..))")
    public void systemLog(JoinPoint joinPoint) {
        StringJoiner log = new StringJoiner("|", "{", "}");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        log.add(sdf.format(new Date()));
        log.add(joinPoint.getTarget().getClass().getName());
        log.add(joinPoint.getSignature().getName());
        log.add(Arrays.toString(joinPoint.getArgs()));
        System.out.println("Log: " + log);
    }
}
