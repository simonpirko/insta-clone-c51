<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.02.2022
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="/images/Instagram_logo.png" alt="" width="1200" height="429">
        </a>
    </div>
</nav>
<br>
<br>
<br>
<div class="row justify-content-md-center">
    <div class="col-md-auto">
        <form action="/passwordReset" method="post">
            <a class="navbar-brand" href="#">
                <img src="/images/lock.png" alt="" width="103" height="118">
            </a>
            <p>
            <h4>Не удается войти?</h4>
            </p>
            <br>
            <p>
            <h6>Введите свой электронный адрес</h6>
            </p>
            <div class="row justify-content-md-center">
                <label><input type="text" name="name" placeholder="Name" required> Name</label>
            </div>
            <br>
            <div class="row justify-content-md-center">
                <label><input type="text" name="username" placeholder="Username" required> Username</label>
            </div>
            <br>
            <div class="row justify-content-md-center">
                <label><input type="text" name="password" placeholder="Password" required> Password</label>
            </div>
            <br>
            <div class="row justify-context-md-center">
                <button>Submit</button>
            </div>
            <br>
            <div class="row justify-context-md-center" role="alert">
                ${requestScope.messageErrorRegistration}
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
