@template.layout.page(
content = @`
    <h1>Создать нового пользователя:</h1>

    <form action="/users" method="post">
        <div>
            <label>
                Имя
                <input type="text" name="firstname" />
            </label>
        </div>
        <div>
            <label>
                Фамилия
                <input type="text" name="lastname" />
            </label>
        </div>
        <div>
            <label>
                Email
                <input type="email" required name="email" />
            </label>
        </div>
        <div>
            <label>
                Пароль
                <input type="password" required name="password" />
            </label>
        </div>
        <div>
            <label>
                Подтверждение пароля
                <input type="password" required name="passwordConfirmation" />
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
)
