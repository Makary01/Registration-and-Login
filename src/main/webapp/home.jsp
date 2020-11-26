<%--
  Created by IntelliJ IDEA.
  User: makary
  Date: 26.11.2020
  Time: 01:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page Title</title>
</head>
<style>
    form {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }
    #buttons{
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
    }
</style>
<body>
<div id="buttons">
    <button onclick="document.querySelector('#register').style.display = 'flex';
                    document.querySelector('#login').style.display = 'none';">register</button>
    <button onclick="document.querySelector('#login').style.display = 'flex';
                    document.querySelector('#register').style.display = 'none';">log in</button>
</div>
<form style="display: none" id="register" action="/register" method="post">
    <h1>register</h1>
    <input type="text" name="name" placeholder="name">
    <input type="text" name="email" placeholder="email">
    <input type="password" name="password" placeholder="password">
    <input type="password" name="password2" placeholder="confirm password">
    <input type="submit" value="register">
</form>
<form id="login" action="/login" method="post">
    <h1>login</h1>
    <input type="text" name="nameOrEmail" placeholder="name or email">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="log in">
</form>
</body>
<script src="app.js"></script>
</html>
