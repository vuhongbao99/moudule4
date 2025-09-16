<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả</title>
</head>
<body>
<h2>Các gia vị bạn chọn:</h2>
<ul>
    <c:forEach var="item" items="${condiments}">
        <li>${item}</li>
    </c:forEach>
</ul>

<a href="<c:url value="/"/>">Quay lại</a>
</body>
</html>
