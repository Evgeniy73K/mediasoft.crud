# Процесс сборки проекта

# Стэк: Java 17, Gradle

Проект использует Spring Boot для запуска веб-сервера и работы с базой данных PostgreSQL в Docker контейнере.

## Запуск приложение

1. Установите Docker и Docker Compose.
2. Клонируйте репозиторий на локальную машину.
3. Перейдите в корневую директорию проекта в терминале.
4. Выполните команду: gradle build
5. Выполните команду sudo docker-compose up --build
6. После запуска, приложение будет доступно по адресу http://localhost:8080
7. Swagger: http://localhost:8080/swagger-ui/
8. Коллекция postman.postman_collection.json

##Тест кейс для вставки товара:
1. Получить список доступных категорий
   curl -X 'GET' \
   'http://localhost:8080/api/v1/categories' \
   -H 'accept: */*'
2. Создать товар, подставив category_id тестовой категории
   curl -X 'POST' \
   'http://localhost:8080/api/v1/create' \
   -H 'accept: */*' \
   -H 'Content-Type: application/json' \
   -d '{
   "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
   "name": "string",
   "article": "string",
   "dictionary": "string",
   "categoryId": "подставить тестовый id",
   "price": 0,
   "qty": 0,
   "createdAt": "2024-03-06",
   "modifiedAt": "2024-03-06"
   }'
3. Убедиться, что товар добавлен 

curl -X 'GET' \
'http://localhost:8080/api/v1/products' \
-H 'accept: */*'


   