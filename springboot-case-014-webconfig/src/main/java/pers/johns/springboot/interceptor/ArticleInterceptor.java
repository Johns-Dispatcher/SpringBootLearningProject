package pers.johns.springboot.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName    : ArticleInterceptor
 * Description  :
 * CreateTime   : 2024/6/7 16:27
 *
 * @author : JohnS
 * @version : 1.0
 */
public class ArticleInterceptor implements HandlerInterceptor {

    private static final String ADMIN_USER = "John";
    private static final String REQUEST_PREFIX = "/article";
    private static final String PARAMETER_NAME = "user";

    /**
     * 验证登录权限
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  处理器
     * @return 是否拥有响应权限
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String user = request.getParameter(PARAMETER_NAME);
        String requestURI = request.getRequestURI();

        boolean result = false;

        if (requestURI.startsWith(REQUEST_PREFIX)) {
            System.out.println("拦截器执行");
            String path = requestURI.split("/")[2];
            System.out.println(path);
            switch (path) {
                case "post", "edit", "remove" -> {
                    if (ADMIN_USER.equals(user)) {
                        result = true;
                    }
                }
            }
        }

        return result;
    }
}
