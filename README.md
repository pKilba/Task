### Роли:
- **Администратор**: Может блокировать и разблокировать счета.
- **Владелец счета**: Может просматривать свой счет, пополнять его и снимать деньги.

## API Эндпоинты
## URL Host   https://task-production-9106.up.railway.app 
### Администратор (admin,admin)

1. **Получить список всех счетов**
   - **URL**: `/admin/accounts`
   - **Метод**: `GET`
   - **Авторизация**: Basic Auth
   - **Пример запроса в Postman**:
     - URL: `https://task-production-9106.up.railway.app/admin/accounts`
     - Метод: `GET`
     - Authorization: Basic Auth (логин: `admin`, пароль: `admin`)

2. **Заблокировать счет**
   - **URL**: `/admin/block/{accountId}`
   - **Метод**: `POST`
   - **Авторизация**: Basic Auth
   - **Пример запроса в Postman**:
     - URL: `https://task-production-9106.up.railway.app/admin/block/1`
     - Метод: `POST`
     - Authorization: Basic Auth (логин: `admin`, пароль: `admin`)

3. **Разблокировать счет**
   - **URL**: `/admin/unblock/{accountId}`
   - **Метод**: `POST`
   - **Авторизация**: Basic Auth
   - **Пример запроса в Postman**:
     - URL: `https://task-production-9106.up.railway.app/admin/unblock/1`
     - Метод: `POST`
     - Authorization: Basic Auth (логин: `admin`, пароль: `admin`)

### Владелец счета (user1,user1; user2,user2)

1. **Получить информацию о своем счете**
   - **URL**: `/user/account`
   - **Метод**: `GET`
   - **Авторизация**: Basic Auth
   - **Пример запроса в Postman**:
     - URL: `https://task-production-9106.up.railway.app/user/account`
     - Метод: `GET`
     - Authorization: Basic Auth (логин: `user1`, пароль: `user1`)

2. **Пополнить счет**
   - **URL**: `/user/deposit`
   - **Метод**: `POST`
   - **Авторизация**: Basic Auth
   - **Пример запроса в Postman**:
     - URL: `https://task-production-9106.up.railway.app/user/deposit`
     - Метод: `POST`
     - Authorization: Basic Auth (логин: `user1`, пароль: `user1`)
     - Body (raw, JSON):
       ```json
       {
         "amount": 500.00
       }
       ```

3. **Снять деньги со счета**
   - **URL**: `/user/withdraw`
   - **Метод**: `POST`
   - **Авторизация**: Basic Auth
   - **Пример запроса в Postman**:
     - URL: `https://task-production-9106.up.railway.app/user/withdraw`
     - Метод: `POST`
     - Authorization: Basic Auth (логин: `user1`, пароль: `user1`)
     - Body (raw, JSON):
       ```json
       {
         "amount": 200.00
       }
       ```
