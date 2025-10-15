package ru.boot.logging.core;

import lombok.Data;

/**
 * LoggingService — сервис для вывода логов.
 * <p>
 * Использует настройки из LoggingProperties для определения включения логирования
 * и префикса уровня сообщений.
 * </p>
 *
 * <p>
 * Метод log выводит сообщение в консоль, если логирование включено.
 * </p>
 *
 * @author agent
 * @since 15.10.2025
 */
@Data
public class LoggingService {

    private final LoggingProperties properties;

    /**
     * Выводит сообщение в консоль с указанным префиксом.
     *
     * @param message сообщение для логирования
     */
    public void log(String message) {
        if (properties.isEnabled()) {
            System.out.println("[" + properties.getPrefix() + "] " + message);
        }
    }
}