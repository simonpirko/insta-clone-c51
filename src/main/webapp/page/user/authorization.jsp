<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11.02.2022
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<br>
<br>
<div class="container">
    <div class="row justify-content-center">
        <div class="row justify-content-center">
            <div class="col-3">
                <img src ="https://www.instagram.com/static/images/homepage/screenshot4.jpg/842fe5699220.jpg">
            </div>
            <div class="col-3">
                <div class="row justify-content-center">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/320px-Instagram_logo.svg.png">

                    <form>
                        <div class="form-floating mb-1 ">
                            <input type="text" name="login" class="form-control" id="floatingInput" placeholder="Login">
                            <label for="floatingInput">Телефон/логин/e-mail</label>
                        </div>
                        <div class="form-floating mb-1">
                            <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                            <label for="floatingPassword">Пароль</label>
                        </div>
                        <div class="d-grid gap-1">
                            <button type="submit" class="btn btn-info">Войти</button>
                        </div>
                    </form>

                    <div class="nav justify-content-center">
                        <a class="nav-link" href="  ">Забыли пароль?</a>
                        <a class="nav-link" href="  ">Зарегистрироваться</a>
                        <p class="text-center">Установите приложение</p>
                        <br>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-6">
                        <a href="URL"><img class="img-fluid" src="https://w7.pngwing.com/pngs/822/688/png-transparent-apple-on-the-app-store-screenshot-iphone-app-store-google-play-store-electronics-text-logo-thumbnail.png" alt="App. Store"></a>
                    </div>
                    <div class="col-6">
                        <a href="URL"><img class="img-fluid" src="https://w7.pngwing.com/pngs/91/37/png-transparent-google-play-android-app-store-android-text-logo-microsoft-store.png" alt="Google Play"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

