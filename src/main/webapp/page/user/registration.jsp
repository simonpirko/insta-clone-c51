<%--
  Created by IntelliJ IDEA.
  User: Larisa
  Date: 12.02.2022
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="row justify-content-center m-1 p-1">
            <div class="col-3">
                <img class="img-fluid" src="../images/Instagram_logo.svg.png" alt="Instagram">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-3">
                <p class="text-center text-muted fw-bold">Зарегистрируйтесь, чтобы смотреть фото и видео ваших
                    друзей</p>
            </div>
        </div>

        <form action="/registration" method="post">
            <div class="row justify-content-center m-1 p-0">
                <div class="col-3">
                    <input required class="form-control form-control-sm" type="text"
                           placeholder="Моб. телефон или эл. адрес"
                           aria-label=".form-control-sm example">
                </div>
            </div>

            <div class="row justify-content-center m-1 p-0">
                <div class="col-3">
                    <input name="nameAndSurname" required class="form-control form-control-sm" type="text" placeholder="Имя и фамилия"
                           aria-label=".form-control-sm example">
                </div>
            </div>

            <div class="row justify-content-center m-1 p-0">
                <div class="col-3">
                    <input name="username" required class="form-control form-control-sm" type="text" placeholder="Имя пользователя"
                           aria-label=".form-control-sm example">
                </div>
            </div>

            <div class="row justify-content-center m-1 p-0">
                <div class="col-3">
                    <input name="password" required class="form-control form-control-sm" type="password" placeholder="Пароль"
                           aria-label=".form-control-sm example">
                </div>
            </div>
        </form>

        <div class="row justify-content-center m-1 p-0">
            <div class="d-grid gap-2 col-3 mx-auto">
                <button name="registration" type="button" class="btn btn-primary">Регистрация</button>
            </div>
        </div>

        <div class="row justify-content-center m-1 p-1">
            <div class="col-3">
                <p class="fs-6 text-center text-muted">Регистрируясь, вы принимаете наши <b>Условия</b>, <b>Политику
                    использования данных</b>
                    и <b>Политику в отношении
                        файлов cookie</b>
                    .</p>
            </div>
        </div>
    </div>

    <div class="row justify-content-center m-1 p-0">
        <div class="col-3">
            <p class="text-center">Есть аккаунт? <a href="URL" class="text-decoration-none">Вход</a></p>
        </div>
    </div>

    <div class="row justify-content-center m-1 p-1">
        <div class="col-3">
            <p class="text-center">Установите приложение</p>
        </div>
    </div>

    <div class="row justify-content-center m-1 p-1">
        <div class="col-1">
            <a href="URL"><img class="img-fluid" src="../images/fb_app.png" alt="App Store"></a>
        </div>
        <div class="col-1">
            <a href="URL"><img class="img-fluid" src="../images/fb_play.png" alt="Google Play"></a>
        </div>
    </div>

</div>
</div>
<footer>
    <div class="container">
        <div class="row justify-content-center">
            <div class="row justify-content-center m-1 p-1">
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Meta</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Информация</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Блог</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Вакансии</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Помощь</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">API</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Конфиденциальность</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Условия</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Популярные аккаунты</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Хэштеги</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Места</p></a>
                </div>
                <div class="col"><a href="URL" class="text-decoration-none"><p class="fs-6 text-center text-muted">Instagram Lite</p></a>
                </div>
            </div>
        </div>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
