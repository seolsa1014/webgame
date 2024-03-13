<%@ page import="java.sql.*, java.io.*, java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>

<%
    String name = request.getParameter("name");
    String retrievedName = "";
    String retrievedSequence = "";

    Connection conn = null;
    PreparedStatement deleteStmt = null;
    PreparedStatement insertStmt = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/websitedb", "root", "690505");

        // Delete all existing rows in the login table
        String deleteQuery = "DELETE FROM login";
        deleteStmt = conn.prepareStatement(deleteQuery);
        deleteStmt.executeUpdate();

        // Insert a new row in the login table
        String insertQuery = "INSERT INTO login (id, name) VALUES (1,?)";
        insertStmt = conn.prepareStatement(insertQuery);
        insertStmt.setString(1, name);
        insertStmt.executeUpdate();

        // Check if the user exists in the users table
        String checkUserQuery = "SELECT * FROM users WHERE name = ?";
        PreparedStatement checkUserStmt = conn.prepareStatement(checkUserQuery);
        checkUserStmt.setString(1, name);
        ResultSet checkUserResult = checkUserStmt.executeQuery();

        if (!checkUserResult.next()) {
            // User not found in the users table, display an error message and redirect to load.jsp
            %>
            <script>
                alert("User not found in the database. Please try again.");
                window.location.href = 'load.jsp';
            </script>
            <%
        } else {
            // User found in the users table, you can continue with additional logic or redirection
            // Store name and sequence in local storage or perform other actions as needed

            // Redirect to lobby.jsp
            %>
            <script>
                window.location.href = 'lobby.jsp';
            </script>
            <%
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (deleteStmt != null) deleteStmt.close();
            if (insertStmt != null) insertStmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
