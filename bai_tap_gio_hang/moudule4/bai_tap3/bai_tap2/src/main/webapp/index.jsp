<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>English-Vietnamese Dictionary</title>
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
            margin-bottom: 10px;
            font-size: 2.5em;
            font-weight: 700;
        }

        .subtitle {
            color: #666;
            margin-bottom: 40px;
            font-size: 1.1em;
        }

        .search-form {
            margin-bottom: 30px;
        }

        .form-group {
            margin-bottom: 25px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: 600;
            color: #555;
            font-size: 1.1em;
        }

        input[type="text"] {
            width: 100%;
            padding: 15px 20px;
            border: 2px solid #e0e0e0;
            border-radius: 50px;
            font-size: 18px;
            transition: all 0.3s ease;
            outline: none;
        }

        input[type="text"]:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
            transform: translateY(-2px);
        }

        button {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 15px 40px;
            border: none;
            border-radius: 50px;
            cursor: pointer;
            font-size: 18px;
            font-weight: 600;
            transition: all 0.3s ease;
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.3);
        }

        button:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(102, 126, 234, 0.4);
        }

        .features {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
            gap: 20px;
            margin-top: 30px;
        }

        .feature {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 15px;
            border-left: 4px solid #667eea;
        }

        .feature-icon {
            font-size: 2em;
            margin-bottom: 10px;
        }

        .feature-title {
            font-weight: 600;
            color: #333;
            margin-bottom: 5px;
        }

        .feature-desc {
            color: #666;
            font-size: 0.9em;
        }

        .sample-words {
            background: #f8f9fa;
            border-radius: 15px;
            padding: 20px;
            margin-top: 20px;
        }

        .sample-title {
            font-weight: 600;
            color: #333;
            margin-bottom: 10px;
        }

        .word-list {
            display: flex;
            flex-wrap: wrap;
            gap: 8px;
            justify-content: center;
        }

        .word-tag {
            background: #667eea;
            color: white;
            padding: 5px 12px;
            border-radius: 20px;
            font-size: 0.9em;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .word-tag:hover {
            background: #764ba2;
            transform: translateY(-1px);
        }

        @media (max-width: 768px) {
            .container {
                padding: 30px 20px;
            }

            h1 {
                font-size: 2em;
            }

            input[type="text"] {
                font-size: 16px;
                padding: 12px 18px;
            }

            button {
                font-size: 16px;
                padding: 12px 30px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>📚 Từ điển Anh-Việt</h1>
    <p class="subtitle">Tra cứu từ vựng tiếng Anh - Tiếng Việt nhanh chóng và chính xác</p>

    <form action="search" method="post" class="search-form">
        <div class="form-group">
            <label for="word">🔍 Nhập từ tiếng Anh cần tra cứu:</label>
            <input type="text"
                   id="word"
                   name="word"
                   placeholder="Ví dụ: hello, computer, love..."
                   required
                   autocomplete="off">
        </div>

        <button type="submit">🚀 Tra cứu</button>
    </form>

    <div class="features">
        <div class="feature">
            <div class="feature-icon">⚡</div>
            <div class="feature-title">Nhanh chóng</div>
            <div class="feature-desc">Tra cứu tức thì</div>
        </div>
        <div class="feature">
            <div class="feature-icon">📖</div>
            <div class="feature-title">Chính xác</div>
            <div class="feature-desc">Nghĩa chuẩn xác</div>
        </div>
        <div class="feature">
            <div class="feature-icon">🌟</div>
            <div class="feature-title">Dễ sử dụng</div>
            <div class="feature-desc">Giao diện thân thiện</div>
        </div>
    </div>

    <div class="sample-words">
        <div class="sample-title">💡 Một số từ mẫu bạn có thể thử:</div>
        <div class="word-list">
            <span class="word-tag" onclick="searchWord('hello')">hello</span>
            <span class="word-tag" onclick="searchWord('computer')">computer</span>
            <span class="word-tag" onclick="searchWord('love')">love</span>
            <span class="word-tag" onclick="searchWord('family')">family</span>
            <span class="word-tag" onclick="searchWord('beautiful')">beautiful</span>
            <span class="word-tag" onclick="searchWord('friend')">friend</span>
            <span class="word-tag" onclick="searchWord('happy')">happy</span>
            <span class="word-tag" onclick="searchWord('school')">school</span>
        </div>
    </div>
</div>

<script>
    function searchWord(word) {
        document.getElementById('word').value = word;
        document.querySelector('.search-form').submit();
    }

    // Auto focus vào input khi trang load
    window.onload = function() {
        document.getElementById('word').focus();
    }

    // Enter để search
    document.getElementById('word').addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            document.querySelector('.search-form').submit();
        }
    });
</script>
</body>
</html>