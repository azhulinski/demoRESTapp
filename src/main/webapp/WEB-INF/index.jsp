<!DOCTYPE html>
<html lang="en">

<head>
    <title>index page</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Custom styles for this template -->
    <style>
        body {
            padding-top: 54px;
            background: silver;
        }

        @media (min-width: 992px) {
            body {
                padding-top: 56px;
            }
        }

        button {
            color: #384047;
            background-color: #384047;
        }

    </style>

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">

    <div class="container">

        <!-- link to registration page -->
        <a class="navbar-brand" href="/registration">register new user</a>

        <!-- button to view all users page -->
        <button id="viewusers" class="navbar-brand">view all users</button>

        <!-- button to find user by id -->
        <button id="searchusers" class="navbar-brand" border='none'>search user</button>

    </div>
</nav>

<!-- container for results -->
<div class="container" id="searchuser">

</div>

</body>

<script>

    //script for search all users 'engine'
    $('#viewusers').click(function () {

        //send ajax request
        $.ajax({
            url: '/viewUsers',
            type: 'GET',
            contentType: 'application/json',
            success: function (response) {
                $("#searchuser").empty(); //reseting field

                //checking for existing data in response
                if (response.length === 0) {

                    //creating new container and putting message to it
                    $('<div/>', {
                        "class": 'col-md',
                        text: "No registered users were found in database"
                    })
                        .appendTo('#searchuser')
                } else {

                    //in case of receiving non empty response iterating through List and values in it
                    $.each(response, function () {
                        $.each(this, function (key, value) {

                            //omitting password field
                            if (key == "password") {
                                return
                            }
                            //creating new container and putting iterated values to it
                            //unfortunately couldn't find out how to create rows in loop and put columns of fields
                            // of User object to them
                            $('<div/>', {
                                "class": 'col-md-auto',
                                text: value
                            }).appendTo('#searchuser')
                        });
                    })
                }
            },

        })
    });

    //script for search one user by id
    //creating new containers for placing input field
    $('#searchusers').click(function () {
        $("#searchuser").empty();

        $('<div/>', {
            "class": 'row',
            "id": 'rowforsearch'
        }).appendTo('#searchuser');

        $('<div/>', {
            "class": 'row',
            "id": 'rowforresult'
        }).appendTo('#searchuser');

        $('<div/>', {
            "class": 'col-md-4',
        }).appendTo('#rowforsearch');
        $('<div/>', {
            "class": 'col-md-2',
        }).appendTo('#rowforsearch');

        $('<input>', {
            "class": 'form-control',
            "type": 'text',
            "placeholder": 'Search',
            "id": "searchfield"
        }).appendTo('.col-md-4');

        //input field with 'keyup' reacting
        $('#searchfield').keyup(function () {
            // $('#searchbutton').click(function () {

            //set value from input field to variable
            var in_string = $(this).val();
            $('#rowforresult').empty();

            //ajax request to database
            $.ajax({
                url: '/searchUser/' + in_string,
                type: 'get',
                contentType: 'application/json',
                success: function (response) {
                    //checking empty response and put message
                    if (response.length === 0) {
                        $('<div/>', {
                            "class": 'col-md',
                            text: "No such user was found in database"
                        })
                            .appendTo('#rowforresult')
                    } else {

                        //in case response wasn't empty - iterating through received object
                        $.each(response, function (key, value) {
                            if (key == "password") {
                                return
                            }
                            $('<div/>', {
                                "class": 'col-md',
                                text: value
                            }).appendTo('#rowforresult')
                        })
                    }
                }
            })
        })

    });

</script>

</html>