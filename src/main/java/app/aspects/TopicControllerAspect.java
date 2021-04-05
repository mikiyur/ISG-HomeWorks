package app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TopicControllerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(* app.controller.TopicController.*(..))")
    public void After(JoinPoint joinPoint) {
        logger.info("after {}", joinPoint.toString());
    }

    @AfterReturning(pointcut = "execution(* app.service.TopicService.*(..))", returning = "returnedObject")
    public void AfterReturning(JoinPoint joinPoint, Object returnedObject){
        logger.info("{} returned {}", joinPoint.toString() , returnedObject);
    }
}
