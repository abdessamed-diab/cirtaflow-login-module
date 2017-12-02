<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/defaultLogin.css" />
    <link rel="stylesheet" type="text/css" href="css/responsive.css" />
    <title>LOGIN</title>
</head>
<body bgcolor="#333">
    <div class="col-4" id="top">
        <span>
            <img id="hd_logo" src="img/hd_logo.png" width="128" height="128">
        </span>
        <span>
                <h1 class="h1-heading">DIAB ABDESSAMED</h1>
        </span>
    </div>

    <div id="div-login-form">

        <form:form action="/index" method="post"  autocomplete="off"
              enctype="application/x-www-form-urlencoded">

            <div class="row" >
                <div class="col-3 col-t-6 col-m-10">
                    <input id="username"
                           name="username"
                           class="ui-input-text"
                           type="text"
                           maxlength="30"
                           placeholder="username"
                           required="true"
                           minlength="6"
                           title="please enter your username"
                    />
                </div>
            </div>

            <div class="row">
                <div class="col-3 col-t-6 col-m-10" >
                    <input id="password"
                           name="password"
                           class="ui-input-text"
                           type="password"
                           maxlength="30"
                           placeholder="password"
                           required="true"
                           minlength="6"
                           title="enter the password"
                    />
                </div>
            </div>

            <div class="row">
                <div class="col-3 col-t-6 col-m-10" >
                    <input id="submit" name="submit" type="submit" class="ui-button ui-button-green btn"
                           value="LOGIN"/>
                </div>
            </div>

        </form:form>

        <form:form action="/facebook/email,user_about_me" method="post" autocomplete="off">

            <div class="row" >
                <div class="col-3 col-t-6 col-m-10">
                    <input id="facebook" type="submit" class="ui-button medium-size ui-button-blue"
                           value="LOGIN with Facebook"  />
                </div>
            </div>

        </form:form>

    </div>

    <div id="bottom">
        <h3>footing</h3>
    </div>

</body>
</html>
