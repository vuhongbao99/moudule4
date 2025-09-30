<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="${pageContext.request.contextPath}/calculate" method="post">
    <input type="number" name="num1" step="any" required>
    <input type="number" name="num2" step="any" required>
    <br><br>
    <button type="submit" name="operator" value="+">Addition(+)</button>
    <button type="submit" name="operator" value="-">Subtraction(-)</button>
    <button type="submit" name="operator" value="*">Multiplication(X)</button>
    <button type="submit" name="operator" value="/">Division(/)</button>
</form>
</body>
</html>
