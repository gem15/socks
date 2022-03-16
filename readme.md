* Используемая БД  PostgreSQL. Схема в файле socks.dll. Параметры подключения в файле  \socks\src\main\resources\application.properties
```
 spring.datasource.username=postgres
 spring.datasource.password=123
```
* Запуск скомпилированного приложения из командной строки
 ```
java -jar socks-0.0.1-SNAPSHOT.jar
```
 На всякий случай прилагаю jar файл. Использовал openjdk version "11.0.8".
 Сервер настроен на порт 
```
localhost:8080/
 ```
Можно запустить с произвольным номером порта
```
 java -jar socks-0.0.1-SNAPSHOT.jar --server.port=XXXX

```
документация сервиса
```
localhost:8080/swagger-ui.html
```
* Unit тест в папке  socks\src\test\java\com\example\socks\service
