# Шаги для запуска автотестов

1. Копируем репозиторий - git clone
2. Устанавливаем Docker Toolbox для Windows
3. В корне папки проекта запускаем команду docker-compose up
4. В корне папки проекта запускаем команду java -jar artifacts\aqa-shop.jar
5. Запускаем тесты командой gradlew clean test
6. Формируем отчеты командой gradlew AllureReport

## Для запуска автотестов с использованием СУБД Postgresql

1. Переходим в ветку Postgresql (git checkout)
2. В корне папки проекта запускаем команду docker-compose down
3. В корне папки проекта запускаем команду docker-compose up
4. В корне папки проекта запускаем команду java -jar artifacts\aqa-shop.jar
5. Запускаем тесты командой gradlew clean test
6. Формируем отчеты командой gradlew AllureReport