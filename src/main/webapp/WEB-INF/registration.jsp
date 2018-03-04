<html>
<head>
    <meta charset="utf-8">

    <title>Register Form</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <style>

        body {
            font-family: 'Nunito', sans-serif;
            color: #384047;
        }

        div {
            max-width: 400px;
            margin: 10px auto;
            padding: 10px 20px;
            background: #f4f7f8;
            border-radius: 8px;
        }

        h1 {
            margin: 0 0 30px 0;
            text-align: center;
        }

        input[type="text"],
        input[type="password"],
        textarea,
        select {
            border: none;
            font-size: 16px;
            height: auto;
            outline: 0;
            padding: 15px;
            width: 100%;
            background-color: #e8eeef;
            color: #8a97a0;
            box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
            margin-bottom: 30px;
        }

        button {
            padding: 19px 39px 18px 39px;
            color: #FFF;
            background-color: #4bc970;
            font-size: 18px;
            text-align: center;
            font-style: normal;
            border-radius: 5px;
            width: 100%;
            border: 1px solid #3ac162;
            border-width: 1px 1px 3px;
            box-shadow: 0 -1px 0 rgba(255, 255, 255, 0.1) inset;
            margin-bottom: 10px;
        }

        fieldset {
            margin-bottom: 30px;
            border: none;
        }


    </style>
</head>
<body>

<div id="form">

    <h1>Register User</h1>

    <fieldset>

        <label for="login">Login:</label>
        <input type="text" id="login" name="login">

        <label for="password">Password:</label>
        <input type="password" id="password" name="password">

        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName">

        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName">

    </fieldset>


    <button type="submit" id="button">Register</button>
</div>

</body>
<script>

    $('#button').click(function () {
        var login = $('#login').val();
        var password = $('#password').val();
        var firstName = $('#firstName').val();
        var lastName = $('#lastName').val();

        var user = JSON.stringify({login: login, password: password, firstName: firstName, lastName: lastName})

        $.ajax({
            url: '/saveUser',
            type: 'POST',
            data: user,
            contentType: 'application/json',
            success: function () {
                $('#login').val("");
                $('#password').val("");
                $('#firstName').val("");
                $('#lastName').val("");
            }

        })
    })


</script>
</html>