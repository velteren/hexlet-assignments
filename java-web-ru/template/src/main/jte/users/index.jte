@import exercise.dto.users.UsersPage
@param UsersPage users

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <main>
        @for(var user: users.getUsers())
            <h2><a href="/users/${user.getId()}">Пользователь ${user.getId()}</a></h2>
        @endfor
    </main>
</body>
</html>