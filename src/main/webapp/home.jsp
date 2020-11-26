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
    <button onclick="document.querySelector('#registerForm').style.display = 'flex';
                    document.querySelector('#loginForm').style.display = 'none';">register</button>
    <button onclick="document.querySelector('#loginForm').style.display = 'flex';
                    document.querySelector('#registerForm').style.display = 'none';">log in</button>
</div>
<form style="display: none" id="registerForm" action="/register" method="post">
    <h1>register</h1>
    <input type="text" name="name" placeholder="user name" required
           pattern="[a-z0-9_-]{5,16}" title="5 to 16 lowercase letters, numbers, _ and -">

    <input type="email" name="email" placeholder="email" required>

    <input type="password" name="password" placeholder="password"
           required pattern=".{5,20}" title="5 to 20 chars" >

    <input type="password" name="password2" placeholder="confirm password"
           required pattern=".{5,20}" title="5 to 20 chars" >

    <input type="submit" value="register">
</form>
<form id="loginForm" action="/login" method="post">
    <h1>login</h1>
    <input type="text" name="nameOrEmail" placeholder="name or email">
    <input type="password" name="password" placeholder="password" required>
    <input type="submit" value="log in">
</form>
<p id="errorMsg"></p>
</body>
</html>
