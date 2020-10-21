<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</header>
<html>
<body>
<h2>Dictionary Simple</h2>
<form action="translate" method="get">
    <label>Tiếng Việt</label>
    <input type="text" name="vietnamese" placeholder="vietnamese"> <br>
    <label>English</label>
    <p>${english}</p>
    <button type="submit">Translate</button>
</form>
</body>
</html>
