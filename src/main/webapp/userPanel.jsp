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
    <title>User Panel Title</title>
</head>
<body>
<div style="display: flex; align-items: center; justify-content: center; flex-direction: column;">
    <h1>Welcome user nr ${userId}</h1>
    <form method="post" action="/user/logout">
        <input type="submit" value="log out">
    </form>
</div>
</form>
</body>
</html>
