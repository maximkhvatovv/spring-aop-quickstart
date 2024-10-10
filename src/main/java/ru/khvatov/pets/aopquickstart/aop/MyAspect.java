package ru.khvatov.pets.aopquickstart.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {

    /**
     * Для методов, класс которых помечен аннотацией {@code @Service}
     */
    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void isServiceLayer() {}

    /**
     * Истина для class type name удовлетворяющих регулярному выражению.
     */
    @Pointcut("within(ru.khvatov.pets.aopquickstart.dao.*Dao)")
    public void isDaoLayer() {}

    @Pointcut("this(ru.khvatov.pets.aopquickstart.api.MyContract)")
    public void implementsMyContract() {}

    /**
     * Истина, если метод помечен аннотацией {@code Audit}.
     */
    @Pointcut("@annotation(ru.khvatov.pets.aopquickstart.auidit.Audit)")
    public void hasAuditAnnotation() {}

    /**
     * args - check method param type
     * <br/>
     * {@code *} any param type
     * <br/>
     * {@code ..} 0+ any param type
     */
    @Pointcut("isDaoLayer() && args(java.lang.Integer,..)")
    public void hasIntegerParam() {}

    /**
     * {@code @args} just check presence of annotation on class type of first parameter of method.
     */
    @Pointcut("isDaoLayer() && @args(jakarta.persistence.Entity,..)")
    public void hasEntityAnnotationOnClassOfMethodParam() {}

    /**
     * {@code bean} check bean name.
     */
    @Pointcut("bean(*Service)")
    public void isServiceLayerBean() {}

    /**
     * {@code execution} check all method metadata.
     */
    @Pointcut("execution(public * ru.khvatov.pets.aopquickstart.dao.*Dao.findById(..))")
    public void findAnyDaoMethodById() {}

    private static long COUNTER;

    @Before(
        value = "isServiceLayer() && args(id,name,..)",
        argNames = "joinPoint,id,name"
    )
    public void doLogging(JoinPoint joinPoint, Long id, String name) {
        log.info("Before service method invocation. Id={}, name={}.", id, name);
    }
}
