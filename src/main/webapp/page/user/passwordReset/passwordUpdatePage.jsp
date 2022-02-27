<%--
  Created by IntelliJ IDEA.
  User: gemuz
  Date: 27.02.2022
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Обновление пароля</title>
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
        <form action="/accounts/password/update/" method="post" class="row justify-content-center">
            <div style="text-align: center;">
                <a class="navbar-brand" href="#">
                    <img src="/page/images/lock.png" alt="lock" width="103" height="100"></a>
                <br>
                <br>
                <div class="row justify-content-center">
                    <c:if test="${requestScope.msgError != null}">
                        ${requestScope.msgError}
                    </c:if>
                     Секретная фраза: ${sessionScope.secretWorld}
                    <label><input type="text" name="inputSecretWord"
                                  required
                                  placeholder="Секретная фраза">
                    </label>
                    <br><br >
                    <label><input type="password" name="updatePassword"
                                  maxlength="30"
                                  minlength="5"
                                  pattern="[A-Za-z0-9]*"
                                  required
                                  placeholder="Новый пароль">
                    </label>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Обновить пароль</button>
            </div>
        </form>
        <br>
        <hr>
    <div style="text-align: center;">
        <a class="nav-link active" aria-current="page" href="/">Вернуться к входу</a>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    </div>
    </div>
</body>
</html>
