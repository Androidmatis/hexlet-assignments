@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
<head>
    <meta charset="utf-8" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Пользователи</title>
</head>
<body>
    <h1>${page.getHeader()}</h1>
    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else
        <div>
            <table style="border: 2px solid rgb(0, 0, 0);">
                <thead>
                <tr>
                    <th style="border: 2px solid rgb(0, 0, 0);">Имя пользователя</th>
                    <th style="border: 2px solid rgb(0, 0, 0);">Email</th>
                </tr>
                </thead>
                <tbody>
                @for(var user : page.getUsers())
                    <tr>
                        <td style="border: 2px solid rgb(0, 0, 0);"><a href="/users/${user.getId()}">${user.getFirstName() + " " + user.getLastName()}</a></td>
                        <td style="border: 2px solid rgb(0, 0, 0);">${user.getEmail()}</td>
                    </tr>
                @endfor
                </tbody>
            </table>
        </div>
    @endif
</body>
</html>