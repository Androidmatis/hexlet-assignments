@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
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
`
)