package school.wastesorting.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * school.wastesorting.controller.UserController.*(..))")
    public void log(){}

    @Before("log()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        logger.info("url={}", attributes.getRequest().getRequestURL());
        logger.info("method={}",attributes.getRequest().getMethod());
        logger.info("class_name={}", joinPoint.getSignature().getDeclaringTypeName());
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void after(){
        logger.info("after");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void afterReturn(Object object){
        logger.info("response={}", object.toString());

    }
}
