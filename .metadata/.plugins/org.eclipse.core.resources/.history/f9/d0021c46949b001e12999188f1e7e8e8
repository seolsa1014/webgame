<%@ page import="java.sql.*, java.io.*, java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kingdom Survive</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="js/newgame.js"></script>
    <script src="js/validation.js"></script>
</head>
<body>
    
    <div class="title">
        <h1>Kingdom&nbsp;&nbsp;Survive</h1>
    </div>

    <div class="buttons">
        <form id="createAccountForm" action="CreateAccount.jsp" method="post" onsubmit="return validateForm()">
            <div class="field">
                <b>Name</b><br>
                <span class="placehold-text"><input type="text" name="name" required></span>
            </div>

            <!-- Add a hidden input field to store the sequence -->
            <input type="hidden" name="sequence" value="">

            <button type="submit" class="button">Submit</button>
            <button type="button" class="button" onclick="goToMain()">Back</button>
        </form>
    </div>

</body>
</html>
