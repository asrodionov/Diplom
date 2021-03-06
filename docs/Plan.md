# План автоматизированного тестирования покупки тура в сервисе «Путешествие дня»

## Вид используемого тестирования

Функциональное


## Перечень автоматизируемых сценариев

### Открытие формы покупки тура

Сценарий №1

1. На главной странице кликнуть кнопку "Купить"

Ожидаем: открывается форма покупки тура с заголовком "Оплата по карте"

### Открытие формы покупки тура в кредит

Сценарий №2

1. На главной странице кликнуть кнопку "Купить в кредит"

Ожидаем: открывается форма покупки тура с заголовком "Кредит по данным карты"

### Отправка формы покупки тура с валидными данными

Сценарий №3

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Успешно. Операция одобрена Банком."

Сценарий №4

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 01
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 999

Ожидаем: Появляется сообщение "Успешно. Операция одобрена Банком."

Сценарий №5

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 12
3. Заполняем поле Год : 20
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Успешно. Операция одобрена Банком."

Сценарий №6

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 09
3. Заполняем поле Год : 25
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 111

Ожидаем: Появляется сообщение "Успешно. Операция одобрена Банком."

### Отправка формы покупки тура с не валидными данными

Сценарий №7

1. Заполняем поле Номер карты : 4444 4444 4444 4442
2. Заполняем поле Месяц : 07
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Ошибка! Банк отказал в проведении операции."

Сценарий №8

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 00
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан срок действия карты. Отправка формы не происходит."

Сценарий №9

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 13
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан срок действия карты. Отправка формы не происходит."

Сценарий №10

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 19
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Истёк срок действия карты. Отправка формы не происходит."

Сценарий №11

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 28
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан срок действия карты. Отправка формы не происходит."

Сценарий №12

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : АНДРЕЙ РОДИОНОВ
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан владелец карты карты. Отправка формы не происходит."

Сценарий №13

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : 123
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан владелец карты карты. Отправка формы не происходит."

Сценарий №14

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : %&$
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан владелец карты карты. Отправка формы не происходит."

### Отправка формы покупки тура в кредит с валидными данными

Сценарий №15

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Успешно. Операция одобрена Банком."

Сценарий №16

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 01
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 999

Ожидаем: Появляется сообщение "Успешно. Операция одобрена Банком."

Сценарий №17

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 12
3. Заполняем поле Год : 20
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Успешно. Операция одобрена Банком."

Сценарий №18

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 09
3. Заполняем поле Год : 25
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 111

Ожидаем: Появляется сообщение "Успешно. Операция одобрена Банком."

### Отправка формы покупки тура в кредит с не валидными данными

Сценарий №19

1. Заполняем поле Номер карты : 4444 4444 4444 4442
2. Заполняем поле Месяц : 07
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Ошибка! Банк отказал в проведении операции."

Сценарий №20

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 00
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан срок действия карты. Отправка формы не происходит."

Сценарий №21

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 13
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан срок действия карты. Отправка формы не происходит."

Сценарий №22

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 19
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Истёк срок действия карты. Отправка формы не происходит."

Сценарий №23

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 28
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан срок действия карты. Отправка формы не происходит."

Сценарий №24

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : АНДРЕЙ РОДИОНОВ
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан владелец карты карты. Отправка формы не происходит."

Сценарий №25

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : 123
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан владелец карты карты. Отправка формы не происходит."

Сценарий №26

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : %&$
5. Заполняем поле CVC/CVV : 691

Ожидаем: Появляется сообщение "Неверно указан владелец карты карты. Отправка формы не происходит."


### Сценарии для проверки корректности внесения данных в БД

Сценарий №27

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: Сумма заказа в БД равна 45000

Сценарий №28

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: поле payment_id в таблице order_entity равно полю transaction_id в таблице payment_entity

Сценарий №29

1. Заполняем поле Номер карты : 4444 4444 4444 4441
2. Заполняем поле Месяц : 06
3. Заполняем поле Год : 21
4. Заполняем поле Владелец : ANDREI RODIONOV
5. Заполняем поле CVC/CVV : 691

Ожидаем: поле credit_id в таблице order_entity равно полю id в таблице credit_request_entity


## Перечень используемых инструментов

- Язык программирования Java (версия 8)

один из самых популярных языков программирования используемый для автоматизированного тестирвоания

- Node.js

необходим для запуска симулятора банковских сервисов

- Intellij IDEA

среда разработки, необходима для написание JAVA кода и unit тестов.

- Gradle 

Быстрое и удобное подключение зависимостей необходимых для тестирования

- Selenide

Необходим для автоматизированного взаимодействия с веб-страницами в ходе проведения тестирования 

- JUNIT

Модуль позволяющий запускать unit тесты и получать вердикты по ним.

- Faker

Библиотека позволяющая генерировать тестовые данные (данные карт)

- Lombok

Поможет сократить код путем автоматического созадния геттеров и сеттеров для работы с переменными.

- Allure

Система формирования отчетов по пройденным тестам. Удобно и быстро подключается. Содержит большое количество отчетов, которые формируются автоматически при прохождении тестов.


## Перечень и описание возможных рисков при автоматизации

- Возможно возникновение сложностей с докеризацией приложения симулятора банковских карт на Node.js 
- Возможно возникновение сложностей с настройкой файла application.properties
- Возможно возникновение сложностей с запуском приложения симулятора банковских карт
- Возможно возникновение сложностей с написанием тестов одновременно работающими с БД на Mysql и PostgreSQL


## Интервальная оценка с учётом рисков (в часах)

12 часа (без учета рисков)

28 часов (при срабатывании фактора риска)


## План сдачи работ

- Автотесты будут сделаны до 26.08.2020

- Отчет по автоматизации будет сделан до 28.08.2020