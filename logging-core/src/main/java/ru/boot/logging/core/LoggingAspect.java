package ru.boot.logging.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * LoggingAspect — аспект для автоматического логирования входа и выхода из методов.
 * <p>
 * Использует LoggingService для вывода сообщений в консоль.
 * Применяется ко всем методам пакета ru.boot..
 * </p>
 *
 * <p>
 * Метод logMethod выводит лог перед вызовом метода и после завершения.
 * </p>
 *
 * @author agent
 * @since 15.10.2025
 */
@Aspect
public class LoggingAspect {

    private final LoggingService loggingService;

    public LoggingAspect(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Around("execution(* ru.boot..*(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        loggingService.log("Entering: " + joinPoint.getSignature());
        Object result = joinPoint.proceed();
        loggingService.log("Exiting: " + joinPoint.getSignature());
        return result;
    }
}