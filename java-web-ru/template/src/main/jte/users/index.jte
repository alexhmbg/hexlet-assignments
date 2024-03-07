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
    <br><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a><br>
    @endfor
@endif
</body>
</html>