<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Kết quả tra cứu - ${searchWord}</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      min-height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
      padding: 20px;
    }

    .container {
      background: white;
      border-radius: 20px;
      box-shadow: 0 20px 40px rgba(0,0,0,0.1);
      padding: 40px;
      width: 100%;
      max-width: 600px;
      text-align: center;
    }

    h1 {
      color: #333;
      margin-bottom: 30px;
      font-size: 2.2em;
      font-weight: 700;
    }

    .search-info {
      background: #f8f9fa;
      border-radius: 15px;
      padding: 20px;
      margin-bottom: 30px;
      border-left: 4px solid #667eea;
    }

    .search-word {
      font-size: 1.8em;
      font-weight: 700;
      color: #667eea;
      margin-bottom: 5px;
    }

    .search-label {
      color: #666;
      font-size: 1em;
    }

    /* Styles for found word */
    .result-found {
      background: linear-gradient(135deg, #00b09b 0%, #96c93d 100%);
      border-radius: 20px;
      padding: 30px;
      margin: 20px 0;
      color: white;
      box-shadow: 0 10px 30px rgba(0, 176, 155, 0.3);
    }

    .success-icon {
      font-size: 3em;
      margin-bottom: 15px;
    }

    .meaning-label {
      font-size: 1.2em;
      margin-bottom: 10px;
      opacity: 0.9;
    }

    .meaning-text {
      font-size: 2em;
      font-weight: 700;
      text-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }

    /* Styles for not found */
    .result-not-found {
      background: linear-gradient(135deg, #ff6b6b 0%, #ffa500 100%);
      border-radius: 20px;
      padding: 30px;
      margin: 20px 0;
      color: white;
      box-shadow: 0 10px 30px rgba(255, 107, 107, 0.3);
    }

    .error-icon {
      font-size: 3em;
      margin-bottom: 15px;
    }

    .error-message {
      font-size: 1.3em;
      margin-bottom: 15px;
    }

    .suggestion {
      background: rgba(255,255,255,0.2);
      border-radius: 10px;
      padding: 15px;
      margin-top: 15px;
    }

    .suggestion-title {
      font-weight: 600;
      margin-bottom: 8px;
    }

    .suggestion-list {
      font-size: 0.95em;
      line-height: 1.5;
    }

    .actions {
      display: flex;
      gap: 15px;
      justify-content: center;
      flex-wrap: wrap;
      margin-top: 30px;
    }

    .btn {
      padding: 12px 25px;
      border: none;
      border-radius: 50px;
      cursor: pointer;
      font-size: 16px;
      font-weight: 600;
      text-decoration: none;
      display: inline-block;
      transition: all 0.3s ease;
    }

    .btn-primary {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
      box-shadow: 0 5px 15px rgba(102, 126, 234, 0.3);
    }

    .btn-primary:hover {
      transform: translateY(-2px);
      box-shadow: 0 8px 25px rgba(102, 126, 234, 0.4);
    }

    .btn-secondary {
      background: #6c757d;
      color: white;
      box-shadow: 0 5px 15px rgba(108, 117, 125, 0.3);
    }

    .btn-secondary:hover {
      background: #5a6268;
      transform: translateY(-2px);
    }

    .stats {
      background: #f8f9fa;
      border-radius: 15px;
      padding: 20px;
      margin-top: 20px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .stat-item {
      text-align: center;
    }

    .stat-number {
      font-size: 1.5em;
      font-weight: 700;
      color: #667eea;
    }

    .stat-label {
      color: #666;
      font-size: 0.9em;
    }

    @media (max-width: 768px) {
      .container {
        padding: 30px 20px;
      }

      h1 {
        font-size: 1.8em;
      }

      .search-word {
        font-size: 1.5em;
      }

      .meaning-text {
        font-size: 1.6em;
      }

      .actions {
        flex-direction: column;
        align-items: center;
      }

      .btn {
        width: 100%;
        max-width: 200px;
      }

      .stats {
        flex-direction: column;
        gap: 15px;
      }
    }
  </style>
</head>
<body>
<div class="container">
  <h1>📖 Kết quả tra cứu</h1>

  <div class="search-info">
    <div class="search-word">"${searchWord}"</div>
    <div class="search-label">Từ bạn vừa tra cứu</div>
  </div>

  <c:choose>
    <c:when test="${found}">
      <!-- Tìm thấy từ -->
      <div class="result-found">
        <div class="success-icon">✅</div>
        <div class="meaning-label">Nghĩa tiếng Việt:</div>
        <div class="meaning-text">${meaning}</div>
      </div>

      <div class="stats">
        <div class="stat-item">
          <div class="stat-number">✓</div>
          <div class="stat-label">Tìm thấy</div>
        </div>
        <div class="stat-item">
          <div class="stat-number">${totalWords}</div>
          <div class="stat-label">Tổng từ vựng</div>
        </div>
        <div class="stat-item">
          <div class="stat-number">🎯</div>
          <div class="stat-label">Chính xác</div>
        </div>
      </div>
    </c:when>
    <c:otherwise>
      <!-- Không tìm thấy từ -->
      <div class="result-not-found">
        <div class="error-icon">❌</div>
        <div class="error-message">
          Xin lỗi, không tìm thấy từ "<strong>${searchWord}</strong>" trong từ điển!
        </div>

        <div class="suggestion">
          <div class="suggestion-title">💡 Gợi ý:</div>
          <div class="suggestion-list">
            • Kiểm tra lại chính tả từ bạn nhập<br>
            • Thử các từ đơn giản như: hello, computer, love, family<br>
            • Từ điển hiện có ${totalWords} từ vựng cơ bản
          </div>
        </div>
      </div>

      <div class="stats">
        <div class="stat-item">
          <div class="stat-number">❌</div>
          <div class="stat-label">Không tìm thấy</div>
        </div>
        <div class="stat-item">
          <div class="stat-number">${totalWords}</div>
          <div class="stat-label">Tổng từ vựng</div>
        </div>
        <div class="stat-item">
          <div class="stat-number">🔍</div>
          <div class="stat-label">Thử lại</div>
        </div>
      </div>
    </c:otherwise>
  </c:choose>

  <div class="actions">
    <a href="../index.jsp" class="btn btn-primary">🔍 Tra từ khác</a>
    <button onclick="history.back()" class="btn btn-secondary">↩️ Quay lại</button>
  </div>
</div>

<script>
  // Auto redirect về trang chủ sau 10 giây nếu không tìm thấy
  <c:if test="${!found}">
  let countdown = 10;
  const countdownInterval = setInterval(() => {
    countdown--;
    if (countdown <= 0) {
      clearInterval(countdownInterval);
      window.location.href = '../index.jsp';
    }
  }, 1000);
  </c:if>
</script>
</body>
</html>