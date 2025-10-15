# Logging Spring Boot Starter

Автоконфигурируемый Spring Boot стартер для автоматического логирования вызовов методов через AOP.

---

## Возможности

- Автоматическое логирование входа и выхода методов без ручного вызова `log()`.
- Настройка префикса логов (`INFO`, `DEBUG` и др.) через `application.yml`.
- Включение и отключение логирования через один флаг.
- Работает «из коробки» с любыми Spring Boot проектами.

---

## Пример работы стартерa

### До подключения Logging Spring Boot Starter

```java
public class ExampleService {
    public void doSomething() {
        System.out.println("Hello World");
    }
}
```
- Вывод будет стандартным: Hello World

### После подключения Logging Spring Boot Starter

```text
[DEBUG] Entering: void ru.boot.example.ExampleService.doSomething()
Hello World
[DEBUG] Exiting: void ru.boot.example.ExampleService.doSomething()
```
---

## Подключение

Добавьте зависимость в ваш проект:

```xml
<dependency>
    <groupId>ru.boot</groupId>
    <artifactId>logging-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

--- 

## Настройки

В application.yml можно настроить:

```yaml
logging:
  starter:
    enabled: true      # Включение/отключение логирования
    prefix: DEBUG      # Префикс уровня логирования (INFO, DEBUG, и т.д.)
```

---

### "Быстрый старт"

Прямо три шага:

1. Добавить зависимость.
2. Настроить `application.yml`.
3. Наслаждаться автоматическим логированием.

---

## Цель проекта

Создать удобный и готовый к использованию стартер, который позволяет легко подключать логирование методов в любых Spring Boot проектах, минимизируя ручное вмешательство и конфигурацию.
