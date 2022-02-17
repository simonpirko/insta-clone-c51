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

    <style>
        .brd {
            border: 1px solid #afabab; /* Параметры границы */
            background: #ffffff; /* Цвет фона */
            padding: 10px; /* Поля вокруг текста */
        }

        .m-2 {
            margin: 0px !important;
            padding: 5px 0px 5px !important;
        }
    </style>
</head>
<body>
<br>
<br>
<div class="container">
    <div class="row justify-content-center">

        <div class="col-4">
            <div class="brd mb-4">

                <div class="row justify-content-center m-4">
                    <img src="/page/images/Instagramlogo.png">
                </div>

                <div class="row justify-content-center">
                    <div class="col-10">

                        <form action="/" method="post">

                            <div class="row justify-content-center m-2">
                                <input type="text" name="login" class="form-control form-control-sm"
                                       placeholder="Телефон, имя пользователя или эл.адрес"
                                       pattern="(^(\+)?(\(\d{2,3}\) ?\d|\d)(([ \-]?\d)|( ?\(\d{2,3}\) ?)){5,12}\d$)|(.+@.+\..+)|(^[\d\w]*$)"
                                       required>
                            </div>

                            <div class="row justify-content-center m-2">
                                <input type="text" name="password" class="form-control form-control-sm"
                                       placeholder="Пароль"
                                       maxlength="30"
                                       minlength="5"
                                       pattern="[A-Za-z0-9]*"
                                       required>
                            </div>

                            <div class="d-grid gap-1 pt-3">
                                <button type="submit" class="btn btn-info">Войти</button>
                            </div>
                        </form>
                    </div>
                </div>


                <div class="row justify-content-center">
                    <div class="col-4">
                        <hr>
                    </div>
                    <div class="col-2">
                        <p class="text-center"> ИЛИ </p>
                    </div>
                    <div class="col-4">
                        <hr>
                    </div>
                </div>

                <div class="nav justify-content-center">
                    <a class="nav-link" href="  ">Забыли пароль?</a>
                </div>
            </div>

            <div class="brd mb-2">
                <div class="nav justify-content-center">
                    <p class="text-center">У вас ещё нет аккаунта?<a href="URL" class="text-decoration-none">
                        Зарегистрироваться</a></p>
                </div>
            </div>


            <div class="row justify-content-center">
                <p class="text-center">Установите приложение.</p>
                <div class="col-4">
                    <a href="https://apps.apple.com/app/instagram/id389801252?vt=lo"><img class="img-fluid"
                                                                                          src="/page/images/fbapp.png"
                                                                                          alt="App. Store"></a>
                </div>
                <div class="col-4">
                    <a href="https://play.google.com/store/apps/details?id=com.instagram.android&referrer=utm_source%3Dinstagramweb&utm_campaign=loginPage&ig_mid=938B65A2-8511-4EE6-9C40-BEF973669FFA&utm_content=lo&utm_medium=badge"><img
                            class="img-fluid" src="/page/images/fbplay.png" alt="Google Play"></a>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<br>

<footer>
    <div class="container">
        <div class="row justify-content-center">
            <div class="row justify-content-center m-1 p-1">
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Meta</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Информация</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Блог</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Вакансии</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Помощь</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    API</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Конфиденциальность</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Условия</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Популярные аккаунты</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Хэштеги</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Места</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">
                    Instagram Lite</p></a>
                </div>
            </div>
        </div>
    </div>
</footer>

</body>
</html>