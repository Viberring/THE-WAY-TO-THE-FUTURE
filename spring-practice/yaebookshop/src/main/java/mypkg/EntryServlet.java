package mypkg;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntryServlet extends HttpServlet {

    private String databaseURL, username, password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        databaseURL = context.getInitParameter("databaseURL");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(databaseURL, username, password);
            stmt = conn.createStatement();
            String sqlStr = "SELECT DISTINCT author FROM books WHERE qty > 0";
            // System.out.println(sqlStr);  // for debugging
            ResultSet rset = stmt.executeQuery(sqlStr);

            out.println("<html><head><title>Welcome to YaEshop</title></head><body>");
            out.println("<h2>Welcome to Yet Another E-BookShop</h2>");
            // Begin an HTML form
            out.println("<form method='get' action='search'>");

            // A pull-down menu of all the authors with a no-selection option
            out.println("Choose an Author: <select name='author' size='1'>");
            out.println("<option value=''>Select...</option>");  // no-selection
            while (rset.next()) {  // list all the authors
                String author = rset.getString("author");
                out.println("<option value='" + author + "'>" + author + "</option>");
            }
            out.println("</select><br />");
            out.println("<p>OR</p>");

            // A text field for entering search word for pattern matching
            out.println("Search \"Title\" or \"Author\": <input type='text' name='search' />");

            // Submit and reset buttons
            out.println("<br /><br />");
            out.println("<input type='submit' value='SEARCH' />");
            out.println("<input type='reset' value='CLEAR' />");
            out.println("</form>");

            out.println("</body></html>");
        } catch (SQLException ex) {
            out.println("<h3>Service not available. Please try again later!</h3></body></html>");
            Logger.getLogger(EntryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EntryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
