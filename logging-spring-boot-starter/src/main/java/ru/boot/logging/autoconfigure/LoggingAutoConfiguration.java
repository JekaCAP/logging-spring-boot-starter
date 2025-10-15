package ru.boot.logging.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.boot.logging.core.LoggingAspect;
import ru.boot.logging.core.LoggingProperties;
import ru.boot.logging.core.LoggingService;

/**
 * LoggingAutoConfiguration — автоконфигурация стартер-модуля логирования.
 * <p>
 * Создает бины LoggingService и LoggingAspect автоматически, если они отсутствуют в контексте.
 * Подключает LoggingProperties из core-модуля.
 * </p>
 *
 * <p>
 * Использование: достаточно добавить стартер в classpath — Spring Boot автоматически подхватит конфигурацию.
 * </p>
 *
 * @author agent
 * @since 15.10.2025
 */
@Configuration
@EnableConfigurationProperties(LoggingProperties.class)
@EnableAspectJAutoProxy
public class LoggingAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public LoggingService loggingService(LoggingProperties properties) {
        return new LoggingService(properties);
    }

    @Bean
    @ConditionalOnMissingBean
    public LoggingAspect loggingAspect(LoggingService loggingService) {
        return new LoggingAspect(loggingService);
    }
}