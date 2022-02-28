<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Восстановление пароля</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar">
    <div class="container">
        <a class="navbar-brand" href="/"><img src="/page/images/instagramlogo.png" alt="" width="120" height="43"></a>
    </div>
</nav>
<br>
<br>
<div class="row justify-content-md-center">
    <div class="col-md-4">
        <form action="/accounts/password/reset/" method="post" class="row justify-content-center">
            <div style="text-align: center;">
                <a class="navbar-brand" href="#">
                    <img src="/page/images/lock.png" alt="lock" width="103" height="100"></a>
                <h4>Не удается войти?</h4> <br>
                <h6>Введите свой электронный адрес, имя</h6>
                <h6>пользователя или номер телефона, и мы</h6>
                <h6>отправим вам ссылку для восстановления</h6>
                <h6>доступа к аккаунту.</h6><br>

                <div class="row justify-content-center">
                    <c:if test="${requestScope.msgError != null}">
                        ${requestScope.msgError}
                    </c:if>
                    <label><input type="text" name="phoneOrEmailOrUserName"
                                  placeholder="Эл.адрес, телефон или имя пользователя"
                                  required
                                  minlength="5"
                                  pattern="(^(\+)?(\(\d{2,3}\) ?\d|\d)(([ \-]?\d)|( ?\(\d{2,3}\) ?)){5,12}\d$)|([a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+)"
                                  style="width: 330px;" style="text-align: center;">
                    </label>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Получить ссылку для входа</button>
        </form>

        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col">
                    <hr>
                </div>
                <div class="col">
                    <h3>или</h3>
                </div>
                <div class="col">
                    <hr>
                </div>
            </div>
        </div>
        <br>
        <a class="nav-link active" aria-current="page" href="/accounts/emailsignup/">Создать новый аккаунт</a>
    </div>

    <div style="text-align: center;">
        <a class="nav-link active" aria-current="page" href="/">Вернуться к входу</a>
    </div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>