<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Kết quả chuyển đổi</title>
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
    .result-box {
      background-color: #e8f5e8;
      border: 2px solid #4CAF50;
      border-radius: 10px;
      padding: 20px;
      margin: 20px 0;
    }
    .conversion-details {
      background-color: #f9f9f9;
      padding: 15px;
      border-radius: 5px;
      margin: 15px 0;
    }
    .amount {
      font-size: 24px;
      font-weight: bold;
      color: #2e7d32;
      text-align: center;
    }
    .back-button {
      background-color: #2196F3;
      color: white;
      padding: 10px 20px;
      text-decoration: none;
      border-radius: 5px;
      display: inline-block;
      margin-top: 20px;
    }
    .back-button:hover {
      background-color: #1976D2;
    }
    .detail-row {
      display: flex;
      justify-content: space-between;
      margin: 10px 0;
      padding: 5px 0;
      border-bottom: 1px dotted #ddd;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>✅ Kết quả chuyển đổi</h1>

  <div class="result-box">
    <div class="amount">
      <fmt:formatNumber value="${vndAmount}" pattern="#,###.##" /> VNĐ
    </div>
  </div>

  <div class="conversion-details">
    <h3>Chi tiết chuyển đổi:</h3>
    <div class="detail-row">
      <span>Số tiền USD:</span>
      <span><strong><fmt:formatNumber value="${usdAmount}" pattern="#,###.##" /> USD</strong></span>
    </div>
    <div class="detail-row">
      <span>Tỉ giá áp dụng:</span>
      <span><strong><fmt:formatNumber value="${exchangeRate}" pattern="#,###.##" /> VNĐ/USD</strong></span>
    </div>
    <div class="detail-row">
      <span>Kết quả:</span>
      <span><strong><fmt:formatNumber value="${vndAmount}" pattern="#,###.##" /> VNĐ</strong></span>
    </div>
  </div>

  <div style="text-align: center;">
    <a href="../index.jsp" class="back-button">← Chuyển đổi lại</a>
  </div>
</div>
</body>
</html>