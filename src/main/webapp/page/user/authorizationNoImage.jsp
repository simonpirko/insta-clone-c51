<%--
  Created by IntelliJ IDEA.
  User: roxbo
  Date: 12.02.2022
  Time: 14:30
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
<div class="container">
    <div class="row justify-content-center">
        <div class="col-3">
            <div class="row justify-content-center">

                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/320px-Instagram_logo.svg.png">
                <input type="text" name="login" placeholder="Телефон/логин/e-mail" required>
                <br>
                <input type="text" name="password" placeholder="Пароль" required>
                <br>
                <button type="submit" class="btn btn-info ">Войти</button>
                <div class="row justify-content-center">
                    <div class="col-auto">
                        <a class="nav-link" href="  ">Забыли пароль?</a>
                        <a class="nav-link" href="  ">Зарегистрироваться</a>
                    </div>
                    <div class="col-auto">
                        <p class="text">Установите приложение</p>
                    </div>
                    <div class="row justify-content">
                        <div class="col">
                            <button type="submit"><img height="60" width="100%"
                                                       src="https://w7.pngwing.com/pngs/822/688/png-transparent-apple-on-the-app-store-screenshot-iphone-app-store-google-play-store-electronics-text-logo-thumbnail.png"
                                                       .../></button>
                        </div>
                        <div class="col">
                            <button type="submit"><img height="60" width="100%"
                                                       src="https://families.google.com/familylink/static/img/google-play/googleplay.ru_ALL.png?cache=c73dc84"
                                                       .../></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>