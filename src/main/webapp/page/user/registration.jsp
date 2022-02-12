<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 12.02.2022
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/accounts/emailsignup" method="post">
        <label id="mob">MobilePhoneOrEmail</label>
        <input type="text" id="mob" name="mobilePhoneOrEmail">
        <c:if test="${requestScope.validationErrors.mobilePhone != null}">
            <p>${requestScope.validationErrors['mobilePhone']}</p>
        </c:if>
        <label id="fn">FirstNameAndLastName</label>
        <input type="text" id="fn" name="firstNameAndLastName">
        <label id="use">Username</label>
        <input type="text" id="use" name="username">
        <c:if test="${requestScope.validationErrors.username != null}">
            <p>${requestScope.validationErrors['username']}</p>
        </c:if>
        <label id="pass">Password</label>
        <input type="password" id="pass" name="password">
        <input type="date" name="birthday">
        <button type="submit">Registration</button>
    </form>
</body>
</html>
