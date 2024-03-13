/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.96
 * Generated at: 2023-12-16 13:45:52 UTC
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

public final class day13_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Castle Page</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/day.css\">\r\n");
      out.write("   <script>\r\n");
      out.write("        function redirectToNextPage(option) {\r\n");
      out.write("            window.location.href = 'next13.jsp?option=' + option;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("      <style>\r\n");
      out.write("    body {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    display: flex;\r\n");
      out.write("    flex-direction: column;\r\n");
      out.write("    align-items: center;\r\n");
      out.write("    justify-content: center;\r\n");
      out.write("    height: 800px;\r\n");
      out.write("    background: url('css/day13.png') center/100% 100% no-repeat;\r\n");
      out.write("}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

      out.write("\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("    <h1>Day ");
      out.print( date );
      out.write("</h1>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"resources\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <p>Gold: ");
      out.print( gold );
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <p>Food: ");
      out.print( food );
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <p>Soldier: ");
      out.print( soldiers );
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <p>Happiness: ");
      out.print( happiness );
      out.write("</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"announcement\">\r\n");
      out.write("    <p>Grain prices have skyrocketed. What action will be taken?</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"buttons\">\r\n");
      out.write("    <button class=\"button\" onclick=\"redirectToNextPage('option1')\">Sell the grain / -5 Food, +10 Gold</button>\r\n");
      out.write("    <button class=\"button\" onclick=\"redirectToNextPage('option2')\">Distribute grain to the people / -5 Food, +1 happiness</button>\r\n");
      out.write("    <button class=\"button\" onclick=\"redirectToNextPage('option3')\">Do nothing.</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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