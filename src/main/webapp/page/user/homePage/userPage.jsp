<%--
  Created by IntelliJ IDEA.
  User: Larisa
  Date: 18.02.2022
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        body {
            background: #f8f9fa;
        }

        small {
            font-size: 0.8rem;
        }
        .links{
            font-size: 0.8rem;
        }
    </style>
</head>
<body>

<%@include file="navbarTop.html" %>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-5">

            <%@include file="friendsStories.html" %>

            <div class="col-12 border bg-white mt-5">
                place for task INST-17
            </div>

        </div>

        <%@include file="navbarRight.html" %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
