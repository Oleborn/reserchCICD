FROM openjdk:21-jdk

## Устанавливаем рабочую директорию
WORKDIR /app

## Копируем собранный JAR-файл в контейнер
COPY target/TestCICD-0.0.1-SNAPSHOT.jar app.jar

# Указываем порт, на котором будет работать приложение
EXPOSE 9090

## Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]