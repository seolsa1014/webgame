<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kingdom Survive</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script>
        function goToMain() {
            window.location.href = 'main.html';
        }
        function goToday() {
        	window.location.href = 'next1.jsp';
        	
        }
    </script>
</head>
<body>
    <div class="title">
        <h1>Kingdom&nbsp;&nbsp;Survive</h1>
    </div>

    <div class="buttons">
        <button class="button" onclick="goToday()">Continue</button>
        <button class="button" onclick="goToMain()">Back</button>
    </div>

</body>
</html>
