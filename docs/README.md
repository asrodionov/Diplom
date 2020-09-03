## Шаги для запуска автотестов с использованием СУБД MySQL

1. Копируем репозиторий - ```git clone```
2. Устанавливаем Docker Toolbox для Windows
3. В корне папки проекта запускаем команду ```docker-compose up```
4. В корне папки проекта запускаем команду ```java -Dspring.datasource.url=jdbc:mysql://192.168.99.100:3306/app -jar artifacts/aqa-shop.jar```
5. Запускаем тесты командой ```gradlew test -Dspring.datasource.url=jdbc:mysql://192.168.99.100:3306/app```
6. Формируем отчеты командой ```gradlew AllureReport```

## Для запуска автотестов с использованием СУБД Postgresql

1. Останавливаем приложение (если оно уже запущено с базой MySQL, если нет , пропускаем шаг) командой - ```Ctrl+C```
2. В корне папки проекта запускаем команду ```java -Dspring.datasource.url=jdbc:postgresql://192.168.99.100:5432/app -jar artifacts/aqa-shop.jar```
3. Запускаем тесты командой ```gradlew test -Dspring.datasource.url=jdbc:postgresql://192.168.99.100:5432/app```
4. Формируем отчеты командой ```gradlew AllureReport```
