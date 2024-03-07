@import exercise.dto.users.UserPage
@param UserPage page

<html>
<head>
    <title>User ${page.getUser().getId()}</title>
</head>
<body>
<h2><a href="/users">Users</a></h2>
<h1>User ${page.getUser().getId()}:</h1>
        <div>
            <table style="width:100%", border="1px solid black">
                <tr>
                    <th>id</th>
                    <th>first_name</th>
                    <th>last_name</th>
                    <th>email</th>
                </tr>
                <tr style="text-align: center">
                    <td>${page.getUser().getId()}</td>
                    <td>${page.getUser().getFirstName()}</td>
                    <td>${page.getUser().getLastName()}</td>
                    <td>${page.getUser().getEmail()}</td>
                </tr>
            </table>
        </div>
</body>
</html>