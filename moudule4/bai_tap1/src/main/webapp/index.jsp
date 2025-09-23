<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Currency Converter - USD to VND</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 2px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }
        input[type="number"]:focus {
            border-color: #4CAF50;
            outline: none;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 12px 30px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>🏦 Chuyển đổi tiền tệ USD → VNĐ</h1>

    <!-- Form action không cần context path khi cùng domain -->
    <form action="convert" method="post">
        <div class="form-group">
            <label for="rate">Tỉ giá USD/VNĐ:</label>
            <input type="number" id="rate" name="rate"
                   value="23000" step="0.01" min="0" required>
            <small style="color: #666;">Ví dụ: 23000 (1 USD = 23,000 VNĐ)</small>
        </div>

        <div class="form-group">
            <label for="usd">Số tiền USD:</label>
            <input type="number" id="usd" name="usd"
                   step="0.01" min="0" required placeholder="Nhập số USD muốn chuyển đổi">
        </div>

        <button type="submit">💱 Chuyển đổi</button>
    </form>
</div>
</body>
</html>