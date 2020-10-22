<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Calculator</h2>
<form action="result" method="post">
    <input type="number" name="number1" size="20" value="${number1}" required>
    <input type="number" name="number2" size="20" value="${number2}" required> <br>
    <button type="submit" name="calculation" value="+">Addition(+)</button>
    <button type="submit" name="calculation" value="-">Subtraction(-)</button>
    <button type="submit" name="calculation" value="*">Multiplication(x)</button>
    <button type="submit" name="calculation" value="/">Division(/)</button>
</form>
<p>${message}</p>
<h4><strong>${result}</strong></h4>
</body>
</html>
