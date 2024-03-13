<%@ page import="java.sql.*, java.io.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Castle Page</title>
    <link rel="stylesheet" type="text/css" href="css/day.css">
    <script>
        function redirectToNextPage(option) {
            window.location.href = 'next12.jsp?option=' + option;
        }
    </script>
      <style>
    body {
    margin: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 800px;
    background: url('css/day12.png') center/100% 100% no-repeat;
}
    </style>
</head>

<body>



<%
    Connection conn = null;
    PreparedStatement pstmtLogin = null;
    PreparedStatement pstmtUser = null;
    ResultSet rsLogin = null;
    ResultSet rsUser = null;

    int gold = 0;
    int food = 0;
    int soldiers = 0;
    int happiness = 0;
    int date = 0;

    try {
        // Establish database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/websitedb", "root", "690505");

        // Get name from login table where id is 1
        String loginQuery = "SELECT name FROM login WHERE id = 1";
        pstmtLogin = conn.prepareStatement(loginQuery);
        rsLogin = pstmtLogin.executeQuery();

        String nameFromLogin = null;

        if (rsLogin.next()) {
            // Get the name from login table
            nameFromLogin = rsLogin.getString("name");

            // Output the name to the browser console
           
        }

        // Execute query to get data using name from login table
        String userQuery = "SELECT date, gold, food, soldiers, happiness FROM users WHERE name = ?";
        pstmtUser = conn.prepareStatement(userQuery);
        pstmtUser.setString(1, nameFromLogin);
        rsUser = pstmtUser.executeQuery();

        // Process the result set and set variables
        if (rsUser.next()) {
        	date = rsUser.getInt("date");
            gold = rsUser.getInt("gold");
            food = rsUser.getInt("food");
            soldiers = rsUser.getInt("soldiers");
            happiness = rsUser.getInt("happiness");
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rsLogin != null) rsLogin.close();
            if (pstmtLogin != null) pstmtLogin.close();
            if (rsUser != null) rsUser.close();
            if (pstmtUser != null) pstmtUser.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
<div class="header">
    <h1>Day <%= date %></h1>
</div>
<div class="resources">
    <%-- Retrieve and display gold --%>
    <p>Gold: <%= gold %></p>

    <%-- Retrieve and display food --%>
    <p>Food: <%= food %></p>

    <%-- Retrieve and display soldier --%>
    <p>Soldier: <%= soldiers %></p>

    <%-- Retrieve and display happiness --%>
    <p>Happiness: <%= happiness %></p>
</div>

<div class="announcement">
    <p>Traders have come to the kingdom, presenting their goods and encouraging investment.</p>
</div>

<div class="buttons">
    <button class="button" onclick="redirectToNextPage('option1')">Invest in the goods / -5 Gold, 50% chance of +10 Gold</button>
    <button class="button" onclick="redirectToNextPage('option2')">Do not invest.</button>
</div>

</body>
</html>


