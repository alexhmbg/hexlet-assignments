@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users:</h1>
@if(page.getUsers().isEmpty())
    <p>No users added yet</p>
@else
    @for(var user : page.getUsers())
        <a href="/users/${user.getId()}">${user.getFirstName()}</a>
    @endfor
@endif
</body>
</html>