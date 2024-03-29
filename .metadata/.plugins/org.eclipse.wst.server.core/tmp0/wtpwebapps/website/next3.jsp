<%@ page import="java.sql.*, java.io.*, java.util.*, org.json.simple.JSONArray, org.json.simple.parser.JSONParser, org.json.simple.parser.ParseException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // 데이터베이스 연결 정보
    String jdbcUrl = "jdbc:mysql://localhost:3306/websitedb";
    String dbUser = "root";
    String dbPassword = "690505";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // JDBC 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 데이터베이스 연결
        conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

        // 로그인한 사용자의 이름 가져오기
        String loggedInName = "";
        String getLoginNameQuery = "SELECT name FROM login WHERE id = 1";
        pstmt = conn.prepareStatement(getLoginNameQuery);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            loggedInName = rs.getString("name");
        } else {
            // 로그인 정보가 없으면 로그인 페이지로 이동
            response.sendRedirect("login.jsp");
            return;
        }

        // 선택지에 따라 데이터베이스 업데이트
         String selectedOption = request.getParameter("option");
        if ("option1".equals(selectedOption)) {
            // 선택지 1에 대한 업데이트 로직 (예시: Soldiers + 10)
            String updateQuery = "UPDATE users SET soldiers = soldiers + 10 WHERE name = ?";
            pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, loggedInName);
            pstmt.executeUpdate();
        } else if ("option2".equals(selectedOption)) {
            // 다른 선택지에 대한 업데이트 로직 추가
        }

        // date가 30인 경우 처리
        String updateDateQuery = "UPDATE users SET date = date + 1 WHERE name = ?";
        pstmt = conn.prepareStatement(updateDateQuery);
        pstmt.setString(1, loggedInName);
        pstmt.executeUpdate();

        // 데이터베이스에서 해당 사용자의 정보 조회
        String query = "SELECT sequence, date FROM users WHERE name = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, loggedInName);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            // sequence와 date 가져오기
            String sequenceString = rs.getString("sequence");
            int date = rs.getInt("date");

            // JSON 문자열을 JSON 배열로 파싱
            JSONParser parser = new JSONParser();
            JSONArray sequenceArray = (JSONArray) parser.parse(sequenceString);

            // date에 해당하는 값을 가져오기

            // date가 30이면 0으로 업데이트하고 ending.html로 리디렉션
            if (date == 31) {
                String resetDateQuery = "UPDATE users SET date = 0 WHERE name = ?";
                pstmt = conn.prepareStatement(resetDateQuery);
                pstmt.setString(1, loggedInName);
                pstmt.executeUpdate();

                response.sendRedirect("ending.html");
            } else {
                long value = (long) sequenceArray.get(date - 1);
                // dayX.jsp로 이동
                String nextPage = "day" + value + ".jsp";
                response.sendRedirect(nextPage);
            }
        } else {
            // 사용자 정보가 없는 경우, 처리할 내용 추가
            response.sendRedirect("load.jsp");
        }
    } catch (ClassNotFoundException | SQLException | ParseException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>




