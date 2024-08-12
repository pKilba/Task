https://task-production-73fb.up.railway.app/

## Доступные эндпоинты

### 1. `/login` (GET)

Эндпоинт для получения странички с Авторизацией.


### 2. `/register` (GET)

Эндпоинт для получения странички с Регистрацией.


### 3. `/banks` (GET)

Эндпоинт для получения странички с информацией о Банках. Требуется Авторизация.


### 4. `/register` (POST)

Эндпоинт для регистрации пользователя.

{
    "username": "",
    "password": ""
}


### 5. `/authenticate` (POST)

Эндпоинт для аунтификации пользователя.

{
    "username": "",
    "password": ""
}
