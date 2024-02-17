@import exercise.dto.users.UserPage
@param UserPage user

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
        <h1>User: ${user.getUser().getFirstName()} ${user.getUser().getLastName()}</h1>
        <h2>ID: ${user.getUser().getId()}</h2>
        <h2>E-Mail: ${user.getUser().getEmail()}</h2>
    </main>
</body>
</html>
