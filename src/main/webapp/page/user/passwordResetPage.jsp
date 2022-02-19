<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    <style>--%>
    <%--        body {--%>
    <%--            background-color: gainsboro;--%>
    <%--        }--%>

    <%--    </style>--%>
</head>
<body>
<nav class="navbar">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="/page/images/instagramlogo.png" alt="" width="120" height="43">
        </a>
    </div>
</nav>
<br>
<br>
<br>
<br>
<br>
<div class="row justify-content-md-center">
    <div class="col-md-4">
        <form action="/passwordReset">
            <div style="text-align: center;">
                <a class="navbar-brand" href="#">
                    <img src="/page/images/lock.png" alt="lock" width="103" height="118">
                </a>
                <p>
                <h4>Не удается войти?</h4>
                </p>
                <br>
                <p>
                <h6>Введите свой электронный адрес, имя</h6>
                </p>
                <p>
                <h6>пользователя или номер телефона, и мы</h6>
                </p>
                <p>
                <h6>отправим вам ссылку для восстановления</h6>
                </p>
                <p>
                <h6>доступа к аккаунту.</h6>
                </p>
                <div class="row justify-content-center">
                    <label><input type="text" name="name" placeholder="Эл.адрес, телефон или имя пользователя" required
                                  style="width: 350px;" style="text-align: center;">
                    </label>
                </div>
                <br>
                <button type="button" class="btn btn-primary">Получить ссылку для входа</button>
                <br>
                <br>
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <hr>
                        </div>
                        <div class="col">
                            <p>
                            <h3>или</h3>
                            </p>
                        </div>
                        <div class="col">
                            <hr>
                        </div>
                    </div>
                </div>
                <br>
                <a class="nav-link active" aria-current="page" href="/accounts/emailsignup/">Создать новый аккаунт</a>


            </div>
        </form>
        <div style="text-align: center;">
            <br>
            <a class="nav-link active" aria-current="page" href="/">Вернуться к входу</a>
            <br>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
