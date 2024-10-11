package ru.khvatov.pets.aopquickstart.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ExceptionHandlerAdvice {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void isRestControllerMethod() {}

    @Around("isRestControllerMethod()")
    public Object handleException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Лучший дебаг на планете Земля. aka BeforeAdvice");
        try {
            log.debug("А это аргументы метода: {}", proceedingJoinPoint.getArgs());
            Object returned = proceedingJoinPoint.proceed();
            log.info("Вот что вернул метод: {}. aka AfterReturningAdvice", returned);
            return returned;
        } catch (Throwable e) {
            log.error(
                "Какой-то чумной эксепшен выпал. А мы чё. Мы ловим: `Error{message={}}`. aka AfterThrowingAdvice",
                e.getMessage()
            );
            throw e;
        } finally {
            log.info("Я в блоке finally\\{} выполняюсь! Привет, дорогой друг! aka AfterAdvice");
        }
    }
}
