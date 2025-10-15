package ru.boot.logging.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * LoggingProperties — класс с настройками логирования.
 * <p>
 * Содержит настройки для включения/отключения логирования и префикс уровня логирования.
 * </p>
 *
 * <ul>
 *     <li>Enabled — включение/отключение логирования</li>
 *     <li>prefix — префикс уровня логирования (например, INFO, DEBUG)</li>
 * </ul>
 *
 * @author agent
 * @since 15.10.2025
 */
@Data
@ConfigurationProperties(prefix = "logging.starter")
public class LoggingProperties {
    private boolean enabled = true;
    private String prefix = "INFO";
}
