<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        body {
            background: #f8f9fa;
        }
        .brd {
            border: 1px solid #afabab; /* Параметры границы */
            background: #ffffff;  /* Цвет фона */
            padding: 10px; /* Поля вокруг текста */
        }
        small {
            font-size: 0.7rem;
        }
        .content {
            width:330px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="content">
            <div class="brd mb-4 mt-4">
                <div class="row justify-content-center">
                    <div class="row justify-content-center">
                            <img class="img-fluid" src="/page/images/instagramlogo.png" alt="Instagram">
                    </div>

                    <div class="row justify-content-center">
                            <p class="text-center text-muted fw-bold">Зарегистрируйтесь, чтобы смотреть фото и видео
                                ваших
                                друзей</p>
                    </div>

                    <form action="/accounts/emailsignup/" method="post" class="row justify-content-center">

                        <c:if test="${sessionScope.errormessage==null}">

                        <div class="row justify-content-center m-1">
                                <input name="phoneOrEmail" required class="form-control form-control-sm" type="text"
                                       minlength="5"
                                       pattern="(^(\+)?(\(\d{2,3}\) ?\d|\d)(([ \-]?\d)|( ?\(\d{2,3}\) ?)){5,12}\d$)|([a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+)"
                                       placeholder="Моб. телефон или эл. адрес">
                        </div>

                        <div class="row justify-content-center m-1">
                                <input name="nameAndSurname" required class="form-control form-control-sm" type="text"
                                       maxlength="30"
                                       minlength="5"
                                       pattern="[A-Za-z]+(\s+[A-Za-z]+)?"
                                       placeholder="Имя и фамилия">
                        </div>

                        <div class="row justify-content-center m-1">
                                <input name="username" required class="form-control form-control-sm" type="text"
                                       maxlength="30"
                                       minlength="5"
                                       pattern="[A-Za-z0-9]*"
                                       placeholder="Имя пользователя">
                        </div>

                        <div class="row justify-content-center m-1">
                                <input name="password" required class="form-control form-control-sm" type="password"
                                       maxlength="30"
                                       minlength="5"
                                       pattern="[A-Za-z0-9]*"
                                       placeholder="Пароль">
                        </div>
                        <div class="row g-1">
                            <div class="form-control-sm col-md-3">
                                <input name="day"
                                       pattern="[0-9]*"
                                       type="text" class="form-control" placeholder="День" required
                                >
                            </div>

                            <div class="form-control-sm col-md-4">
                                <input name="month"
                                       pattern="[0-9]*"
                                       type="text" class="form-control" placeholder="Месяц" required>
                            </div>

                            <div class="form-control-sm col-md-5">
                                <input name="year"
                                       pattern="[0-9]*"
                                       type="text" class="form-control" placeholder="Год рождения" required>
                            </div>
                        </div>

                        </c:if>

                        <c:if test="${sessionScope.errormessage!=null}">
                            <div class="row justify-content-center m-1">
                                <input name="phoneOrEmail" required class="form-control form-control-sm" type="text"
                                       minlength="5"
                                       pattern="(^(\+)?(\(\d{2,3}\) ?\d|\d)(([ \-]?\d)|( ?\(\d{2,3}\) ?)){5,12}\d$)|([a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+)"
                                       value="${sessionScope.phoneOrEmail}">
                            </div>

                            <div class="row justify-content-center m-1">
                                <input name="nameAndSurname" required class="form-control form-control-sm" type="text"
                                       maxlength="30"
                                       minlength="5"
                                       pattern="[A-Za-z]+(\s+[A-Za-z]+)?"
                                       value="${sessionScope.nameAndSurname}">
                            </div>

                            <div class="row justify-content-center m-1">
                                <input name="username" required class="form-control form-control-sm" type="text"
                                       maxlength="30"
                                       minlength="5"
                                       pattern="[A-Za-z0-9]*"
                                       value="${sessionScope.username}">
                            </div>

                            <div class="row justify-content-center m-1">
                                <input name="password" required class="form-control form-control-sm" type="password"
                                       maxlength="30"
                                       minlength="5"
                                       pattern="[A-Za-z0-9]*"
                                       value="${sessionScope.password}">
                            </div>

                            <div class="row g-1">
                                <div class="form-control-sm col-md-3">
                                    <input name="day"
                                           pattern="[0-9]*"
                                           type="text" class="form-control" value="${sessionScope.day}" required>
                                </div>

                                <div class="form-control-sm col-md-4">
                                    <input name="month"
                                           pattern="[0-9]*"
                                           type="text" class="form-control" value="${sessionScope.month}" required>
                                </div>

                                <div class="form-control-sm col-md-5">
                                    <input name="year"
                                           pattern="[0-9]*"
                                           type="text" class="form-control" value="${sessionScope.year}" required>
                                </div>
                            </div>

                        </c:if>

                        <div class="row justify-content-center m-1">
                            <input name="registration" required class="btn btn-primary" type="submit" value="Регистрация"
                                   aria-label=".form-control-sm example">
                        </div>
                        <c:if test="${sessionScope.errormessage!=null}">
                            <div class="row justify-content-center">
                                <div class="col-8">
                                    <p class="text-center" style="color: red" > ${sessionScope.errormessage} </p>
                                </div>
                            </div>
                        </c:if>
                    </form>

                    <div class="row justify-content-center mt-1">
                            <small class="text-center text-muted m-1">Регистрируясь, вы принимаете наши <b>Условия</b>, <b>Политику
                                использования данных</b>
                                и <b>Политику в отношении
                                    файлов cookie</b>
                                .</small>
                    </div>
                </div>
            </div>
            <div class="brd mb-4">
                <div class="row justify-content-center">
                        <p class="text-center m-1">Есть аккаунт? <a href="URL" class="text-decoration-none">Вход</a></p>
                </div>
            </div>
                <div class="row justify-content-center">
                        <p class="text-center">Установите приложение</p>
                </div>

                <div class="row justify-content-center">
                    <div class="col-6">
                        <a href="URL"><img class="img-fluid" src="/page/images/fbapp.png" alt="App Store"></a>
                    </div>
                    <div class="col-6">
                        <a href="URL"><img class="img-fluid" src="/page/images/fbplay.png" alt="Google Play"></a>
                    </div>
                </div>

        </div>
    </div>
</div>
</div>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
