import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.boot.logging.core.LoggingProperties;
import ru.boot.logging.core.LoggingService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * LoggingServiceTest — тесты для класса LoggingService.
 * <p>
 * Проверяет корректность логирования сообщений с учетом настроек LoggingProperties.
 * Этот тест перехватывает вывод в консоль и проверяет, что:
 * <ul>
 *     <li>Сообщение выводится в консоль;</li>
 *     <li>В сообщении используется правильный префикс уровня логирования.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Цель теста — убедиться, что LoggingService корректно работает с LoggingProperties.
 * </p>
 *
 * @author agent
 * @since 15.10.2025
 */
@DisplayName("Тесты LoggingService")
public class LoggingServiceTest {

    /**
     * Проверяет, что метод log выводит сообщение в консоль с правильным префиксом.
     */
    @Test
    @DisplayName("log() — выводит сообщение в консоль с указанным префиксом")
    void logShouldPrintMessage() {
        LoggingProperties props = new LoggingProperties();
        props.setEnabled(true);
        props.setPrefix("DEBUG");

        LoggingService service = new LoggingService(props);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        service.log("Hello");

        String output = out.toString().trim();
        Assertions.assertTrue(output.contains("Hello"));
        Assertions.assertTrue(output.contains("DEBUG"));
    }
}