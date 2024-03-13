/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.96
 * Generated at: 2023-12-16 11:30:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public final class next6_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.json.simple.parser.ParseException");
    _jspx_imports_classes.add("org.json.simple.parser.JSONParser");
    _jspx_imports_classes.add("org.json.simple.JSONArray");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Castle Page</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/day.css\">\r\n");
      out.write("    <script>\r\n");
      out.write("        function redirectToPreviousPage() {\r\n");
      out.write("            window.location.href = 'day6.jsp';\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            height: 800px;\r\n");
      out.write("            background: url('css/day6.png') center/100% 100% no-repeat;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");

        // 데이터베이스 연결 정보
        String jdbcUrl = "jdbc:mysql://localhost:3306/websitedb";
        String dbUser = "root";
        String dbPassword = "690505";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // gold와 food 변수 선언
        int gold = 0;
        int food = 0;

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

            // 사용자의 정보 가져오기 (gold, food)
            String getUserInfoQuery = "SELECT gold, food FROM users WHERE name = ?";
            pstmt = conn.prepareStatement(getUserInfoQuery);
            pstmt.setString(1, loggedInName);
            rs = pstmt.executeQuery();

            // Process the result set and set variables
            if (rs.next()) {
                gold = rs.getInt("gold");
                food = rs.getInt("food");
            }

            // 선택지에 따라 데이터베이스 업데이트
            String selectedOption = request.getParameter("option");
            if ("option1".equals(selectedOption)) {
                // 옵션 1: Buy food / gold - 5, food + 5
                // 골드 부족 시 경고 처리
                if (gold >= 5) {
                    String updateQuery = "UPDATE users SET gold = gold - 5, food = food + 5 WHERE name = ?";
                    pstmt = conn.prepareStatement(updateQuery);
                    pstmt.setString(1, loggedInName);
                    pstmt.executeUpdate();
                } else {
                    // 골드 부족 시 경고창을 띄우고 이전 페이지로 이동
                    out.println("<script>alert('Not enough gold!');</script>");
                    out.println("<script>window.location.href='day6.jsp';</script>");
                    return;
                }
            } else if ("option2".equals(selectedOption)) {
                // 옵션 2: Sell food / gold + 5, food - 5
                // 푸드 부족 시 경고 처리
                if (food >= 5) {
                    String updateQuery = "UPDATE users SET gold = gold + 5, food = food - 5 WHERE name = ?";
                    pstmt = conn.prepareStatement(updateQuery);
                    pstmt.setString(1, loggedInName);
                    pstmt.executeUpdate();
                } else {
                    // 푸드 부족 시 경고창을 띄우고 이전 페이지로 이동
                    out.println("<script>alert('Not enough food!');</script>");
                    out.println("<script>window.location.href='day6.jsp';</script>");
                    return;
                }
            } else if ("option3".equals(selectedOption)) {
                // 옵션 3: Do not engage in trade. (아무런 업데이트 없음)
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
    
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
