package top.byteinfo.springmall.web.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 *
 *
 * HttpServletRequest
 * ProceedingJoinPoint
 * TODO 完成基本编码后 参考zlt2000  修改Oauth2登录接口:oauth/token 返回类型.
 */
@Aspect
@Component//
public class GlobalAspect {




    @Around("execution(top.byteinfo.springmall.* *())")
    public Object doAround(){
        return null;
    }
}
