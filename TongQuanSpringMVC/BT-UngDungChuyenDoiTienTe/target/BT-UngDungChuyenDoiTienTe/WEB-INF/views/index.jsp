
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</header>
<html>
<body>
<h2>Chuyển đổi USD - VND</h2>

<form action="convert" method="get">
    <label>VND</label>
    <input type="number" name="vnd" placeholder="Vnd" value="${result1}">
    <label>USD</label>
    <input type="number" name="usd" placeholder="Usd" value="${result2}">
    <button type="submit">Convert</button>
</form>
</body>
</html>
